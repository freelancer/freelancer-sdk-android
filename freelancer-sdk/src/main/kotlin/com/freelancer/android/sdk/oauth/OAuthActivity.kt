package com.freelancer.android.sdk.oauth

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.freelancer.android.flapi.BuildConfig
import com.freelancer.android.flapi.R
import kotlinx.android.synthetic.main.activity_oauth.*
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class OAuthActivity : AppCompatActivity() {

    private var subscribe: Subscription? = null

    companion object {

        val RESULT_OK = 0
        val RESULT_ERROR = 1
        val KEY_TOKEN = "token"
        val KEY_ERROR = "error"

        private val OAUTH_AUTHORISE_ENDPOINT = "oauth/authorise"

        private val KEY_CLIENT_ID = "KEY_CLIENT_ID"
        private val KEY_REDIRECT_URI = "KEY_REDIRECT_URI"
        private val KEY_SECRET = "KEY_SECRET"
        private val KEY_ADVANCED_SCOPED = "KEY_ADVANCED_SCOPED"
        private val KEY_IS_SANDBOX = "KEY_IS_SANDBOX"
        private val KEY_REQUEST_CODE = "KEY_REQUEST_CODE"
        private val KEY_IS_DEBUG = "KEY_IS_DEBUG"

        fun startActivityForResult(activity: Activity,
                requestCode: Int,
                clientId: String,
                secret: String,
                redirectUri: String,
                advancedScopes: String?,
                isSandbox: Boolean = false,
                isDebug: Boolean = false) {

            val intent = Intent(activity, OAuthActivity::class.java).apply {
                putExtra(KEY_REQUEST_CODE, requestCode)
                putExtra(KEY_CLIENT_ID, clientId)
                putExtra(KEY_REDIRECT_URI, redirectUri)
                putExtra(KEY_SECRET, secret)
                putExtra(KEY_IS_SANDBOX, isSandbox)
                putExtra(KEY_IS_DEBUG, isDebug)

                advancedScopes?.let {
                    putExtra(KEY_ADVANCED_SCOPED, advancedScopes)
                }
            }

            activity.startActivityForResult(intent, requestCode)
        }
    }

    private lateinit var baseUrl: String
    private lateinit var clientId: String
    private lateinit var secret: String
    private lateinit var redirectUri: String
    private var requestCode: Int = 0
    private var advancedScopes: String? = null
    private var isSandbox: Boolean = false
    private var isDebug: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
        supportActionBar?.title = getString(R.string.freelancer)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.freelancer_blue)))

        requestCode = intent.getIntExtra(KEY_REQUEST_CODE, 0)
        clientId = intent.getStringExtra(KEY_CLIENT_ID)
        redirectUri = intent.getStringExtra(KEY_REDIRECT_URI)
        advancedScopes = intent.getStringExtra(KEY_ADVANCED_SCOPED)
        secret = intent.getStringExtra(KEY_SECRET)
        isSandbox = intent.getBooleanExtra(KEY_IS_SANDBOX, false)
        isDebug = intent.getBooleanExtra(KEY_IS_DEBUG, false)

        baseUrl = if (isSandbox) {
            BuildConfig.BASE_OAUTH_URL_SANDBOX
        } else {
            BuildConfig.BASE_OAUTH_URL
        }

        requestAuthorization()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun buildOAuthUrl(): String {
        val uri = Uri.parse(baseUrl).buildUpon()
                .appendPath(OAUTH_AUTHORISE_ENDPOINT)
                .appendQueryParameter("scope", "basic")
                .appendQueryParameter("response_type", "code")
                .appendQueryParameter("client_id", clientId)
                .appendQueryParameter("redirect_uri", redirectUri)

        advancedScopes?.let {
            uri.appendQueryParameter("advanced_scopes", advancedScopes)
        }

        return uri.build().toString()
    }

    private fun requestAuthorization() {
        val flWebViewClient = FLWebViewClient()
        val webSettings = webView.settings
        webSettings.allowFileAccess = false
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.webViewClient = flWebViewClient
        webView.loadUrl(buildOAuthUrl())

        webView.visibility = View.INVISIBLE
        webView.webChromeClient = WebChromeClient()
    }

    inner class FLWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            webView.visibility = View.VISIBLE
            spinner.visibility = View.GONE


            if (url.contains("?error")) {
                webView.visibility = View.GONE

                val uri = Uri.parse(url)
                val error = uri.getQueryParameter("error")
                val reason = uri.getQueryParameter("error_description")

                val intent = Intent()
                intent.putExtra(KEY_ERROR, OAuthException(error ?: "", reason ?: ""))
                setResult(RESULT_ERROR, intent)
                finish()
            } else if (url.contains("?code=")) {
                webView.visibility = View.GONE

                deleteCookies()
                val uri = Uri.parse(url)
                val authCode = uri.getQueryParameter("code")
                requestAccessToken(authCode)
            }
        }
    }

    private fun requestAccessToken(authCode: String) {
        if (isDebug) {
            OAuthService.isDebug = isDebug
        }
        if (isSandbox) {
            OAuthService.isSandbox = isSandbox
        }

        subscribe = OAuthService.getInstance().grant(
                grantType = "authorization_code",
                code = authCode,
                clientId = clientId,
                clientSecret = secret,
                redirectUri = redirectUri)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ tokenResponse ->

                    val intent = Intent()
                    intent.putExtra(KEY_TOKEN, tokenResponse)
                    setResult(RESULT_OK, intent)

                    finish()
                }, { error ->
                    val intent = Intent()
                    intent.putExtra(KEY_ERROR, OAuthException(error.toString(), error.message ?: ""))
                    setResult(RESULT_ERROR, intent)
                    finish()
                })
    }

    override fun onStop() {
        super.onStop()
        subscribe?.let {
            if (!it.isUnsubscribed) {
                it.unsubscribe()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()

        return false
    }

    private fun deleteCookies() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            CookieManager.getInstance().removeAllCookies({ })
        } else {
            @Suppress("DEPRECATION")
            CookieManager.getInstance().removeAllCookie()
        }
    }
}

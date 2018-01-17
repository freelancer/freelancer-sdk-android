package com.freelancer.android.flsdkandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.freelancer.android.sdk.Freelancer
import com.freelancer.android.sdk.oauth.OAuthActivity
import com.freelancer.android.sdk.oauth.OAuthActivity.Companion.KEY_ERROR
import com.freelancer.android.sdk.oauth.OAuthActivity.Companion.KEY_TOKEN
import com.freelancer.android.sdk.oauth.OAuthException
import com.freelancer.android.sdk.oauth.OAuthTokenResponse
import kotlinx.android.synthetic.main.activity_sample.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SampleActivity : AppCompatActivity() {

    val REQUEST_CODE_OAUTH = 100

    private var flApi: Freelancer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        getUserButton.setOnClickListener {
            //Sample usage
            flApi?.let {
                it.createUserApi().getUserById(23880056)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ user ->
                            Log.v("Found User", user.name)
                            textBox.text = user.name
                        }, {
                            Toast.makeText(this, "Error getting user", Toast.LENGTH_SHORT).show()
                        })
            } ?: Toast.makeText(this, "Error FLApi must not be null null", Toast.LENGTH_SHORT).show()
        }

        oAuthButton.setOnClickListener {
            // Create an application
            // [Sandbox] https://accounts.freelancer-sandbox.com/settings/create_app
            // [Production] https://accounts.freelancer.com/settings/create_app

            val clientId = ""
            val secret = ""
            val redirectUri = ""
            val advancedScopes = "1 2 3 4 5"
            val isSandbox = true
            val isDebug = true

            OAuthActivity.startActivityForResult(this, REQUEST_CODE_OAUTH, clientId, secret, redirectUri, advancedScopes, isSandbox, isDebug)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_OAUTH) {
            if (resultCode == OAuthActivity.RESULT_OK) {
                val token = data?.getParcelableExtra<OAuthTokenResponse>(KEY_TOKEN)
                token?.let {
                    Toast.makeText(this, "Access token: " + it.accessToken, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "ExpiresIn: " + it.expiresIn, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Refresh_Token: " + it.refresh_token, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Scope: " + it.scope, Toast.LENGTH_SHORT).show()
                    Toast.makeText(this, "Token Type: " + it.tokenType, Toast.LENGTH_SHORT).show()

                    Log.d(SampleActivity::class.java.simpleName, "Access token: " + it.accessToken)

                    flApi = Freelancer(it.accessToken, BuildConfig.APPLICATION_ID, isDebug = true, isSandbox = true)

                    getUserButton.visibility = View.VISIBLE
                }
            } else {
                val error = data?.getSerializableExtra(KEY_ERROR) as OAuthException
                Toast.makeText(this, "Error: ${error.error}, reason: ${error.reason}", Toast.LENGTH_LONG).show()
            }
        }
    }
}

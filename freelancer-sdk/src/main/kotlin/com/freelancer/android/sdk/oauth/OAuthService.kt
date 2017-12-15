package com.freelancer.android.sdk.oauth

import com.freelancer.android.flapi.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

internal interface OAuthServiceInterface {
    @POST("oauth/token")
    @FormUrlEncoded
    fun grant(@Field("grant_type") grantType: String,
            @Field("code") code: String,
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String,
            @Field("redirect_uri") redirectUri: String
    ): Observable<OAuthTokenResponse>
}

internal object OAuthService {

    var isSandbox: Boolean = false
    var isDebug: Boolean = false

    private var INSTANCE: OAuthServiceInterface? = null

    fun getInstance(): OAuthServiceInterface =
            INSTANCE ?: buildOAuthService().also { INSTANCE = it }

    private fun buildOAuthService(): OAuthServiceInterface {

        val baseUrl = if (isSandbox) {
            BuildConfig.BASE_OAUTH_URL_SANDBOX
        } else {
            BuildConfig.BASE_OAUTH_URL
        }

        val clientBuilder = OkHttpClient.Builder()

        if (isDebug) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(interceptor)
        }

        val client = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(clientBuilder.build())
                .build()

        return client.create(OAuthServiceInterface::class.java)
    }
}
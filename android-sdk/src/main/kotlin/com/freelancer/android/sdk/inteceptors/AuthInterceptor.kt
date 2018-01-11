package com.freelancer.android.sdk.inteceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(
        private val header: String,
        private val token: String
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
                .addHeader(header, token)
        request = builder.build()
        return chain.proceed(request)
    }
}

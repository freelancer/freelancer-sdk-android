package com.freelancer.android.sdk.inteceptors

import okhttp3.Interceptor
import okhttp3.Response

internal class UserAgentInteceptor(private val userAgent: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
                .removeHeader("User-Agent")
                .addHeader("User-Agent", userAgent)
        request = builder.build()
        return chain.proceed(request)
    }

}
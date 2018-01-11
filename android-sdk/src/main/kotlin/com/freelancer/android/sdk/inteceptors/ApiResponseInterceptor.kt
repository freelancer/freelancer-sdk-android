package com.freelancer.android.sdk.inteceptors

import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.utils.GSON
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody

internal class ApiResponseInterceptor : Interceptor {
    private val JSON = MediaType.parse("application/json; charset=utf-8")

    override fun intercept(chain: Interceptor.Chain?): Response? {
        chain ?: return null

        val request = chain.request()
        val response = chain.proceed(request)
        val contentType = response.headers().get("content-type")
        if ("application/json" == contentType) {
            val body = response.body()
            var bodyString = body.string()
            val apiResponse = GSON.fromJson(bodyString, ApiResponse::class.java)
            body?.close()

            val newResponse = response.newBuilder()
            apiResponse?.result?.let {
                bodyString = apiResponse.result.toString()
            }

            return newResponse.body(ResponseBody.create(JSON, bodyString))
                    .build()
        } else if (contentType.contains("text/html")) {
            val body = response.body()
            val bodyString = body.string()
            body?.close()
            if (bodyString.contains("verified") && bodyString.contains("data")) {
                return response.newBuilder().body(ResponseBody.create(JSON, bodyString))
                        .build()
            }
        }
        return response
    }
}
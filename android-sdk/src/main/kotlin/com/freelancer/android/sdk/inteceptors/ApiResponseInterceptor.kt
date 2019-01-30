package com.freelancer.android.sdk.inteceptors

import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.utils.GSON
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody

internal class ApiResponseInterceptor : Interceptor {
    private val JSON = MediaType.parse("application/json; charset=utf-8")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val body = response.body()
        val contentType = response.headers().get("content-type")
        body?.let {
            if ("application/json" == contentType) {
                var bodyString = it.string()
                val apiResponse = GSON.fromJson(bodyString, ApiResponse::class.java)
                it.close()

                val newResponse = response.newBuilder()
                apiResponse?.result?.let { bodyString = apiResponse.result.toString() }

                return newResponse
                        .body(ResponseBody.create(JSON, bodyString))
                        .build()
            } else if (contentType!!.contains("text/html")) {
                val bodyString = body.string()
                it.close()
                if (bodyString.contains("verified") && bodyString.contains("data")) {
                    return response
                            .newBuilder()
                            .body(ResponseBody.create(JSON, bodyString))
                            .build()
                }
            }
        }
        return response
    }
}
package com.freelancer.android.sdk.models.response

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class ApiResponse(
        @SerializedName("status")
        val status: String,

        @SerializedName("message")
        val message: String? = null,

        @SerializedName("error_code")
        val errorCode: String? = null,

        @SerializedName("result")
        val result: JsonElement? = null
)

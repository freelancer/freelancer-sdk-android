package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.FLObject
import com.google.gson.annotations.SerializedName

data class AddAttachmentResponse(
        @SerializedName("access_hash")
        var accessHash: String? = null,

        @SerializedName("time_submitted")
        var timeSubmitted: String? = null,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("filename")
        var filename: String? = null,

        @SerializedName("contentType")
        var contentType: String? = null,

        @SerializedName("id")
        var serverId: Long = 0

) : FLObject

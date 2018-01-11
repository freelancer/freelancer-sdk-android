package com.freelancer.android.sdk.models

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class ProjectAttachment(

        @Transient var projectId: Long = 0,

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("time_submitted")
        var timeSubmitted: Long = 0,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("filename")
        var name: String? = null,

        @SerializedName("content_type")
        var contentType: String? = null,

        var uri: Uri? = null
) : FLObject
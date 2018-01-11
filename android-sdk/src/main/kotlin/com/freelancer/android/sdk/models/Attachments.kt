package com.freelancer.android.sdk.models

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class Attachment(
        @SerializedName("filename")
        var name: String? = null,

        @SerializedName("message_id")
        var serverMessageId: Long = 0,

        var mimeType: String? = null,

        var uri: Uri? = null,

        var isDownloading: Boolean = false
) : FLObject
package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class EntryFile(
        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("thumbnail_900_url")
        var thumbnailUrl: String? = null,

        @SerializedName("file_url")
        var fileUrl: String? = null
) : FLObject
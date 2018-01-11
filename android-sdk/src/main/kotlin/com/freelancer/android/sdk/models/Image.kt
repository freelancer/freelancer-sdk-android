package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Image(

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("width")
        var width: Int = 0,

        @SerializedName("height")
        var height: Int = 0,

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("description")
        var description: String? = null

) : FLObject
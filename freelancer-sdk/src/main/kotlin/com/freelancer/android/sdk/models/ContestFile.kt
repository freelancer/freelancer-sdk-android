package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

class ContestFile(
        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("name")
        var fileName: String? = null,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("deleted")
        var deleted: Boolean = false

) : FLObject
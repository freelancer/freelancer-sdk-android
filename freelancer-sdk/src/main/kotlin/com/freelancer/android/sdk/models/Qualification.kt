package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Qualification(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("level")
        var level: Int = 0,

        @SerializedName("icon_url")
        var iconUrl: String? = null,

        @SerializedName("type")
        var type: String? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("icon_name")
        var iconName: String? = null,

        @SerializedName("score_percentage")
        var scorePercentage: Int = 0,

        @SerializedName("user_percentile")
        var userPercentile: Int = 0

) : FLObject
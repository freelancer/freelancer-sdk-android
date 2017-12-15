package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ProjectUpgrades(

        @SerializedName("NDA")
        var isNda: Boolean = false,

        @SerializedName("assisted")
        var isAssisted: Boolean = false,

        @SerializedName("urgent")
        var isUrgent: Boolean = false,

        @SerializedName("featured")
        var isFeatured: Boolean = false,

        @SerializedName("nonpublic")
        var isNonPublic: Boolean = false,

        @SerializedName("fulltime")
        var isFulltime: Boolean = false,

        @SerializedName("qualified")
        var isQualified: Boolean = false,

        @SerializedName("sealed")
        var isSealed: Boolean = false

) : FLObject
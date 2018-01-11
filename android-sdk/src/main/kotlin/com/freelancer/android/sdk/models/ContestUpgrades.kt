package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ContestUpgrades(
        @SerializedName("highlighted")
        var isHighlighted: Boolean = false,

        @SerializedName("urgent")
        var isUrgent: Boolean = false,

        @SerializedName("featured")
        var isFeatured: Boolean = false,

        @SerializedName("nonpublic")
        var isNonPublic: Boolean = false,

        @SerializedName("sealed")
        var isSealed: Boolean = false,

        @SerializedName("topcontest")
        var isTopContest: Boolean = false
) : FLObject
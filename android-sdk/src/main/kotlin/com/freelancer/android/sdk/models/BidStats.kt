package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class BidStats(
        @SerializedName("bid_count")
        var bidCount: Long = 0,

        @SerializedName("bid_avg")
        var bidAverage: Float = 0.toFloat()
) : FLObject
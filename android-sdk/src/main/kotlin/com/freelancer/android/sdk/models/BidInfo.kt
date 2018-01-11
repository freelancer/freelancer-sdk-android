package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class BidInfo(

        @SerializedName("project_id")
        var projectId: Long = 0,

        @SerializedName("maximum_bid")
        var maximumBid: Double = 0.0,

        @SerializedName("minimum_fee")
        var minimumFee: Double = 0.0,

        @SerializedName("range")
        var range: Int = 0,

        @SerializedName("minimum_sponsor_increment")
        var minimumSponsorIncrement: Double = 0.0,

        @SerializedName("current_highlight_count")
        var currentHighlightCount: Int = 0,

        @SerializedName("highlight_currency")
        var highlightCurrency: Currency? = null,

        @SerializedName("minimum_bid")
        var minimumBid: Double = 0.0,

        @SerializedName("rate")
        var rate: Double = 0.0,

        @SerializedName("maximum_highlight_count")
        var maximumHighlightCount: Int = 0,

        @SerializedName("highlight_cost")
        var highlightCost: Double = 0.0
) : FLObject
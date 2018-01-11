package com.freelancer.android.sdk.models.request

import com.google.gson.annotations.SerializedName

data class BidRequest(
        @SerializedName("project_id")
        var projectId: Int,

        @SerializedName("bidder_id")
        var bidderID: Int,

        @SerializedName("amount")
        var amount: Float = 0f,

        @SerializedName("period")
        var period: Int = 0,

        @SerializedName("milestone_percentage")
        var milestonePercentage: Float = 0f
)

package com.freelancer.android.sdk.models.request

import com.google.gson.annotations.SerializedName

data class UpdateBidRequest(
        @SerializedName("description")
        var description: String,

        @SerializedName("amount")
        var amount: Float = 0f,

        @SerializedName("period")
        var period: Int = 0,

        @SerializedName("milestone_percentage")
        var milestonePercentage: Float = 0f
)
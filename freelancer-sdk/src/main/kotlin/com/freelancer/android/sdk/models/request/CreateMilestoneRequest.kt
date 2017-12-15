package com.freelancer.android.sdk.models.request

import com.google.gson.annotations.SerializedName

data class CreateMilestoneRequest(
        @SerializedName("bidder_id")
        var bidderID: Int,

        @SerializedName("project_id")
        var projectId: Int,

        @SerializedName("amount")
        var amount: Float = 0f,

        @SerializedName("description")
        var description: String = "",

        @SerializedName("reason")
        var reason: String = "",

        @SerializedName("request_id")
        var requestId: Int
)
package com.freelancer.android.sdk.models.request

import com.google.gson.annotations.SerializedName

data class CreateMilestoneRequestRequest(

        @SerializedName("project_id")
        var projectId: Int,

        @SerializedName("bid_id")
        var bidId: Int,

        @SerializedName("amount")
        var amount: Float = 0f,

        @SerializedName("description")
        var description: String = ""
)
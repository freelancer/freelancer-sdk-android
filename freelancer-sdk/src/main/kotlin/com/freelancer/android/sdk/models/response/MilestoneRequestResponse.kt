package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.MilestoneRequest
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class MilestoneRequestResponse(
        @SerializedName("milestone_requests")
        val milestoneRequestsObj: Map<Long, MilestoneRequest>?,

        @SerializedName("users")
        val users: Map<Long, FLUser>?
)
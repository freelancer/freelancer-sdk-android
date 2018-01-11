package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Milestone
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class MilestoneResponse(
        @SerializedName("milestones")
        val milestonesObj: Map<Long, Milestone>?,

        @SerializedName("users")
        val users: Map<Long, FLUser>?,

        var milestoneItems: List<Milestone> = emptyList()
)

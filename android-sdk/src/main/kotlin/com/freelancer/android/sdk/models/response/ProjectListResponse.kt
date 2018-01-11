package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Bid
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class ProjectListResponse(
        @SerializedName("projects")
        val projects: List<Project>,
        @SerializedName("selected_bids")
        val selectedBidsMap: Map<Long, List<Bid>>? = null,
        @SerializedName("users")
        val usersMap: Map<Long, FLUser>? = null
)
package com.freelancer.android.sdk.models.request

import com.freelancer.android.sdk.models.ReputationData
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class PostReviewRequest(
        @SerializedName("project_id")
        val projectId: Int,

        @SerializedName("to_user_id")
        val toUserId: Int,

        @SerializedName("from_user_id")
        val fromUserId: Int,

        @SerializedName("role")
        val role: FLUser.Role,

        @SerializedName("reputation_data")
        val reputationData: ReputationData? = null,

        @SerializedName("comment")
        val comment: String

)
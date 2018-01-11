package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Contest
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.Review
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class ReviewResponse(
        @SerializedName("reviews")
        val reviews: List<Review>,

        @SerializedName("users")
        val users: Map<Long, FLUser>? = null,

        @SerializedName("contests")
        val contests: Map<Long, Contest>? = null,

        @SerializedName("projects")
        val projects: Map<Long, Project>? = null

)

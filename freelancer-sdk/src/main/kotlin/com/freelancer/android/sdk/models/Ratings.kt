package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Ratings(
        @SerializedName("project_id")
        var projectId: Long = 0,

        @SerializedName("on_time")
        var onTime: Boolean = false,

        @SerializedName("paid_amount")
        var paidAmount: Float = 0.toFloat(),

        @SerializedName("time_submitted")
        var timeSubmitted: Long = 0,

        @SerializedName("on_budget")
        var onBudget: Boolean = false,

        @SerializedName("submitdate")
        var submitDate: Long = 0,

        @SerializedName("category_ratings")
        var categoryRating: CategoryRating? = null,

        @SerializedName("role")
        var role: FLUser.Role? = null,

        @SerializedName("project_type")
        var projectType: Project.ProjectType? = null,

        @SerializedName("from_user_id")
        var fromUserId: Long = 0,

        @SerializedName("to_user_id")
        var toUserId: Long = 0,

        @SerializedName("description")
        var description: String? = null

) : FLObject
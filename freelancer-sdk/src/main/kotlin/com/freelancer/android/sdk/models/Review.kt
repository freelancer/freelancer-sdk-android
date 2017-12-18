package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Review(
        @SerializedName("to_user_id")
        var toUserId: Long = 0,

        @SerializedName("from_user_id")
        var fromUserId: Long = 0,

        @SerializedName("role")
        var role: FLUser.Role? = null,

        @SerializedName("status")
        var reviewStatus: ReviewStatus? = null,

        @SerializedName("time_submitted")
        var timeSubmitted: Long = 0,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("rating")
        var rating: Float = 0f,

        @SerializedName("review_project_status")
        var reviewProjectStatus: ReviewProjectStatus? = null,

        @SerializedName("rating_details")
        var ratingDetails: RatingDetails? = null,

        @SerializedName("review_context")
        var reviewContext: ReviewContext? = null,

        @SerializedName("currency")
        var currency: Currency? = null,

        @SerializedName("ratings")
        var ratings: List<Ratings>? = null,

        @SerializedName("bid_amount")
        var bidAmount: Float = 0f,

        @SerializedName("sealed")
        var sealed: Boolean = false,

        @SerializedName("paid_amount")
        var paidAmount: Float = 0f,

        @SerializedName("featured")
        var featured: Boolean = false,

        @SerializedName("submitdate")
        var submitdate: Long = 0,

        @SerializedName("project_id")
        var projectId: Long = 0,

        var toUser: FLUser? = null,

        var fromUser: FLUser? = null,

        var project: Project? = null

) : FLObject {

    enum class ReviewStatus {
        PENDING,
        AWAITING,
        ACTIVE,
        WITHDRAWN,
        HIDDEN,
        DENIED,
        EXPIRED;

        override fun toString(): String = name.toLowerCase()
    }

    enum class ReviewProjectStatus {
        COMPLETE,
        INCOMPLETE;

        override fun toString(): String {
            return name.toLowerCase()
        }
    }
}
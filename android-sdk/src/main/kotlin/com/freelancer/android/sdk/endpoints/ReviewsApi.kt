package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.FLUser
import com.freelancer.android.sdk.models.Review
import com.freelancer.android.sdk.models.ReviewContext
import com.freelancer.android.sdk.models.request.PostReviewRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.ReviewResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReviewsApi {

    @GET("reviews")
    fun getReviews(
            @Query("projects[]") projects: List<Long>?,
            @Query("from_users[]") fromUserIds: List<Long>?,
            @Query("to_users[]") toUserIds: List<Long>?,
            @Query("contests[]") contests: List<Long>?,
            @Query("review_types[]") reviewTypes: ReviewContext.ReviewType?,
            @Query("job_ids[]") jobIds: List<Long>?,
            @Query("completion_statuses") completion_statuses: Review.ReviewProjectStatus?,
            @Query("from_time") fromTime: Long?,
            @Query("to_time") toTime: Long?,
            @Query("project_details") project_details: Boolean = true,
            @Query("ratings") ratings: Boolean = true,
            @Query("role") role: FLUser.Role?,
            @Query("contest_details") contestDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("project_full_description") projectFullDescription: Boolean = true,
            @Query("project_upgrade_details") projectUpgradeDetails: Boolean = true,
            @Query("project_job_details") projectJobDetails: Boolean = true,
            @Query("project_selected_bids") projectSelectedBids: Boolean = true,
            @Query("project_qualification_details") projectQualificationDetails: Boolean = true,
            @Query("project_attachment_details") projectAttachmentDetails: Boolean = true,
            @Query("project_hireme_details") projectHiremeDetails: Boolean = true,
            @Query("contest_job_details") contestJobDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true,
            @Query("user_country_details") userCountryDetails: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancialDetails: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") user_status: Boolean = true,
            @Query("user_reputation") userReputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") userReputationExtra: Boolean = true,
            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
            @Query("user_cover_image") userCoverImage: Boolean = true,
            @Query("user_past_cover_images") userPastCoverImages: Boolean = true,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporate_users: Boolean = true,
            @Query("limit") limit: Long,
            @Query("offset") offset: Long,
            @Query("compact") compact: Boolean
    ): Single<ReviewResponse>

    @POST("reviews")
    fun postProjectReview(@Body postReviewRequest: PostReviewRequest): Single<ApiResponse>

    /**
     * TODO
     *
     * add endpoint for review actions
     * /project/0.1/reviews/{review_id}/{?action}
     */
}

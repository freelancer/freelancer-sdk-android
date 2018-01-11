package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Milestone
import com.freelancer.android.sdk.models.request.CreateMilestoneRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.MilestoneResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface MilestoneApi {

    @GET("milestones/")
    fun getMilestonesByProjectId(
            @Query("projects[]") projectId: List<Long>?,
            @Query("project_owners[]") projectOwners: List<Long>?,
            @Query("bidders[]") bidders: List<Long>?,
            @Query("users[]") userId: List<Long>?,
            @Query("bids[]") bids: List<Long>?,
            @Query("statuses[]") status: List<Milestone.MilestoneStatus>?,
            @Query("user_avatar") user_avatar: Boolean = true,
            @Query("user_country_details") userCountryDetails: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") userBalanceDetails: Boolean = true,
            @Query("user_qualification_details") userQualificationDetails: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancialDetails: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") userStatus: Boolean = true,
            @Query("user_reputation") reputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") user_reputation_extra: Boolean = true,
            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
            @Query("user_cover_image") userCoverImage: Boolean = true,
            @Query("user_past_cover_images") userPastCoverImages: Boolean = true,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporateUsers: Boolean = true
    ): Observable<MilestoneResponse>

    @POST("milestones")
    fun createMilestone(@Body createMilestoneRequest: CreateMilestoneRequest): Observable<Milestone>

    @PUT("milestones/{milestone_id}/")
    fun performMilestoneAction(
            @Path("milestone_id") milestoneRequestId: Long,
            @Query("action") action: Milestone.MilestoneAction,
            @Query("amount") amount: Float
    ): Observable<ApiResponse>
}
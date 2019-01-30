package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Bid
import com.freelancer.android.sdk.models.request.BidRequest
import com.freelancer.android.sdk.models.request.UpdateBidRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.BidsResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface BidsApi {

    @GET("/bids/")
    fun getBids(
            @Query("bids[]") bids: List<Long>,
            @Query("projects[]") projects: List<Long>,
            @Query("bidders[]") bidders: List<Long>,
            @Query("project_owners[]") owners: List<Long>,
            @Query("award_statuses[]") awardStatus: List<Bid.BidStatus>,
            @Query("paid_statuses[]") paidStatus: List<Bid.PaidStatus>,
            @Query("complete_statuses[]") completeStatus: List<Bid.BidCompleteStatus>,
            @Query("frontend_bid_statuses[]") frontendBidStatus: List<Bid.FrontendBidStatus>,
            @Query("from_time") fromTime: Long,
            @Query("to_time") toTime: Long,
            @Query("reputation") reputation: Boolean,
            @Query("buyer_project_fee") buyerProjectFee: Boolean,
            @Query("award_status_possibilities") award_status_possibilities: Boolean,
            @Query("user_details") userDetails: Boolean,
            @Query("user_avatar") userAvatar: Boolean,
            @Query("user_country_details") userCountryDetails: Boolean,
            @Query("user_profile_description") userProfileDescription: Boolean,
            @Query("user_jobs") userJobs: Boolean,
            @Query("user_balance_details") userBalanceDetails: Boolean,
            @Query("user_qualification_details") userQualificationDetails: Boolean,
            @Query("user_membership_details") userMembershipDetails: Boolean,
            @Query("user_financial_details") userFinancialDetails: Boolean,
            @Query("user_location_details") userLocationDetails: Boolean,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean,
            @Query("user_preferred_details") userPreferredDetails: Boolean,
            @Query("user_badge_details") userBadgeDetails: Boolean,
            @Query("user_status") userStatus: Boolean,
            @Query("user_reputation") userReputation: Boolean,
            @Query("user_employer_reputation") userEmployerReputation: Boolean,
            @Query("user_reputation_extra") userReputationExtra: Boolean,
            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean,
            @Query("user_cover_image") userCoverImage: Boolean,
            @Query("user_past_cover_images") userPastCoverImages: Boolean,
            @Query("user_responsiveness") userResponsiveness: Boolean,
            @Query("corporate_users") corporateUsers: Boolean,
            @Query("limit") limit: Long,
            @Query("offset") offset: Long,
            @Query("compact") compact: Boolean
    ): Single<List<Bid>>

    @GET("bids")
    fun getBidsByBidsId(@Query("bids[]") bidIds: List<Long>,
                        @Query("award_status_possibilities") awardStatusPossibilities: Boolean = true,
                        @Query("buyer_project_fee") buyerProjectFee: Boolean = true,
                        @Query("reputation") reputation: Boolean = true): Single<BidsResponse>

    @GET("bids")
    fun getBidsByProjectsId(@Query("projects[]") projectIds: List<Long>,
                            @Query("award_status_possibilities") awardStatusPossibilities: Boolean = true,
                            @Query("buyer_project_fee") buyerProjectFee: Boolean = true,
                            @Query("reputation") reputation: Boolean = true): Single<List<Bid>>

    @GET("bids")
    fun getBidsByBidderId(@Query("bidders[]") bidderIds: List<Long>,
                          @Query("award_status_possibilities") awardStatusPossibilities: Boolean = true,
                          @Query("buyer_project_fee") buyerProjectFee: Boolean = true,
                          @Query("reputation") reputation: Boolean = true): Single<List<Bid>>

    @GET("bids")
    fun getBidsByProjectOwnerId(@Query("project_owners[]") projectOwnerIds: List<Long>,
                                @Query("award_status_possibilities") award_status_possibilities: Boolean = true,
                                @Query("buyer_project_fee") buyer_project_fee: Boolean = true,
                                @Query("reputation") reputation: Boolean = true): Single<List<Bid>>

    @GET("bids/{bid_id}")
    fun getBidById(
            @Path("bid_id") bidId: Long,
            @Query("reputation") reputation: Boolean,
            @Query("buyer_project_fee") buyerProjectFee: Boolean,
            @Query("award_status_possibilities") award_status_possibilities: Boolean,
            @Query("user_details") userDetails: Boolean,
            @Query("user_avatar") userAvatar: Boolean,
            @Query("user_country_details") userCountryDetails: Boolean,
            @Query("user_profile_description") userProfileDescription: Boolean,
            @Query("user_jobs") userJobs: Boolean,
            @Query("user_balance_details") userBalanceDetails: Boolean,
            @Query("user_qualification_details") userQualificationDetails: Boolean,
            @Query("user_membership_details") userMembershipDetails: Boolean,
            @Query("user_financial_details") userFinancialDetails: Boolean,
            @Query("user_location_details") userLocationDetails: Boolean,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean,
            @Query("user_preferred_details") userPreferredDetails: Boolean,
            @Query("user_badge_details") userBadgeDetails: Boolean,
            @Query("user_status") userStatus: Boolean,
            @Query("user_reputation") userReputation: Boolean,
            @Query("user_employer_reputation") userEmployerReputation: Boolean,
            @Query("user_reputation_extra") userReputationExtra: Boolean,
            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean,
            @Query("user_cover_image") userCoverImage: Boolean,
            @Query("user_past_cover_images") userPastCoverImages: Boolean,
            @Query("user_responsiveness") userResponsiveness: Boolean,
            @Query("corporate_users") corporateUsers: Boolean,
            @Query("limit") limit: Long,
            @Query("offset") offset: Long,
            @Query("compact") compact: Boolean
    ): Single<Bid>

    @POST("bids")
    fun createBid(@Body bidRequest: BidRequest): Single<Bid>

    @PUT("bids/{bid_id}/")
    fun updateBid(@Path("bid_id") bidId: Long, @Body updateBidRequest: UpdateBidRequest): Single<Bid>

    @PUT("bids/{bid_id}/")
    @FormUrlEncoded
    fun performBidAction(@Path("bid_id") bidId: Long, @Field("action") bidAction: String): Single<ApiResponse>
}

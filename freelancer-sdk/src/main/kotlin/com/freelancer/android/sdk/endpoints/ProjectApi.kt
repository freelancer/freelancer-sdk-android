package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.BidInfo
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.request.PostProjectRequest
import com.freelancer.android.sdk.models.request.PutProjectActionRequest
import com.freelancer.android.sdk.models.response.AddAttachmentResponse
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.BidsResponse
import com.freelancer.android.sdk.models.response.ProjectListResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ProjectApi {
    @POST("projects")
    fun createProject(@Body project: PostProjectRequest): Observable<Project>

    @PUT("projects/{project_id}/")
    fun projectActions(@Path("project_id") projectId: Long,
            @Body action: PutProjectActionRequest): Observable<ApiResponse>

    @GET("projects?compact")
    fun listProjects(@Query("projects[]") projectIds: List<Long>? = null,
            @Query("owners[]") ownerId: List<Long>? = null,
            @Query("seo_urls[]") seoUrls: List<String>? = null,
            @Query("from_time") fromTime: Long? = null,
            @Query("to_time") to_time: Long? = null,
            @Query("frontend_project_statuses[]") frontendProjectStatus: MutableList<Project.FrontendProjectStatus>? = null,
            @Query("count") count: Boolean = true,
            @Query("full_description") fullDescription: Boolean = true,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("upgrade_details") upgradeDetails: Boolean = true,
            @Query("attachment_details") attachmentDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("qualification_details") qualificationDetails: Boolean = true,
            @Query("selected_bids") selectedBids: Boolean = true,
            @Query("hireme_details") hiremeDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("invited_freelancer_details") invitedFreelancerDetails: Boolean = true,
            @Query("recommended_freelancer_details") recommendedFreelancerDetails: Boolean = true,
            @Query("support_session_details") supportSessionDetails: Boolean = true,
            @Query("location_details") locationDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true,
            @Query("user_country_details") userCountryDetails: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancial_Details: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") userStatus: Boolean = true,
            @Query("user_reputation") userReputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") userReputationExtra: Boolean = true,
            //FIXME These errors will currently cause a 500 (should actually be 400) from the api
//            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
//            @Query("user_cover_image") userCoverImage: Boolean = true,
//            @Query("user_past_cover_images") userPastCoverImages: Boolean = true,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporateUsers: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int): Observable<ProjectListResponse>

    @GET("projects/{project_id}/")
    fun getProjectById(@Path("project_id") projectId: Long,
            @Query("full_description") fullDescription: Boolean = true,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("upgrade_details") upgradeDetails: Boolean = true,
            @Query("attachment_details") attachmentDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("qualification_details") qualificationDetails: Boolean = true,
            @Query("selected_bids") selectedBids: Boolean = true,
            @Query("hireme_details") hiremeDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("invited_freelancer_details") invitedFreelancerDetails: Boolean = true,
            @Query("recommended_freelancer_details") recommendedFreelancerDetails: Boolean = true,
            @Query("support_session_details") supportSessionDetails: Boolean = true,
            @Query("location_details") locationDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true,
            @Query("user_country_details") userCountryDetails: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancial_Details: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") userStatus: Boolean = true,
            @Query("user_reputation") userReputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") userReputationExtra: Boolean = true,
            //FIXME These errors will currently cause a 500 (should actually be 400) from the api
//            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
//            @Query("user_cover_image") userCoverImage: Boolean = true,
//            @Query("user_past_cover_images") userPastCoverImages: Boolean = true,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporateUsers: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int): Observable<Project>

    @GET("projects/active")
    fun searchActiveProjects(@Query("query") query: String? = null,
            @Query("or_search_query") orSearchQuery: String? = null,
            @Query("project_types[]") projectTypes: List<String>? = null,
            @Query("include_contests") includeContests: Boolean = true,
            @Query("project_upgrades[]") projectUpgrades: List<String>? = null,
            //TODO add contest upgrades
            @Query("min_avg_price") minAvgPrice: Double? = null,
            @Query("max_avg_price") maxAvgPrice: Double? = null,
            @Query("min_avg_hourly_rate") minAvgHourlyRate: Double? = null,
            @Query("max_avg_hourly_rate") maxAvgHourlyRate: Double? = null,
            @Query("jobs[]") jobs: List<Long>? = null,
            @Query("countries[]") countries: List<String>? = null,
            @Query("languages[]") languages: List<String>? = null,
            @Query("sort_field") sort_field: String? = null,
            @Query("reverse_sort") reverseSort: Boolean = false,
            @Query("highlight_pre_tags") highlightPreTags: String? = null,
            @Query("highlight_post_tags") highlightPostTags: String? = null,
            @Query("full_description") fullDescription: Boolean = true,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("upgrade_details") upgrade_details: Boolean = true,
            @Query("user_details") user_details: Boolean = true,
            @Query("user_location_details") user_location_details: Boolean = true,
            @Query("user_avatar") user_avatar: Boolean = true,
            @Query("user_country_details") user_country_details: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancial_Details: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") userStatus: Boolean = true,
            @Query("user_reputation") userReputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") userReputationExtra: Boolean = true,
            //FIXME These errors will currently cause a 500 (should actually be 400) from the api
//            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
//            @Query("user_cover_image") userCoverImage: Boolean = true,
//            @Query("user_past_cover_images") userPastCoverImages: Boolean = true,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporateUsers: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int): Observable<ProjectListResponse>

    @GET("projects/all")
    fun searchAllProjects(@Query("query") query: String? = null,
            @Query("or_search_query") orSearchQuery: String? = null,
            @Query("project_types[]") projectTypes: List<String>? = null,
            @Query("include_contests") includeContests: Boolean = true,
            @Query("project_upgrades[]") projectUpgrades: List<String>? = null,
            //TODO add contest upgrades
            @Query("min_avg_price") minAvgPrice: Double? = null,
            @Query("max_avg_price") maxAvgPrice: Double? = null,
            @Query("min_avg_hourly_rate") minAvgHourlyRate: Double? = null,
            @Query("max_avg_hourly_rate") maxAvgHourlyRate: Double? = null,
            @Query("jobs[]") jobs: List<Long>? = null,
            @Query("countries[]") countries: List<String>? = null,
            @Query("languages[]") languages: List<String>? = null,
            @Query("sort_field") sort_field: String? = null,
            @Query("reverse_sort") reverseSort: Boolean = false,
            @Query("highlight_pre_tags") highlightPreTags: String? = null,
            @Query("highlight_post_tags") highlightPostTags: String? = null,
            @Query("full_description") fullDescription: Boolean = true,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("upgrade_details") upgrade_details: Boolean = true,
            @Query("user_details") user_details: Boolean = true,
            @Query("user_location_details") user_location_details: Boolean = true,
            @Query("user_avatar") user_avatar: Boolean = false,
            @Query("user_country_details") user_country_details: Boolean = true,
            @Query("user_profile_description") userProfileDescription: Boolean = true,
            @Query("user_display_info") userDisplayInfo: Boolean = true,
            @Query("user_jobs") userJobs: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_membership_details") userMembershipDetails: Boolean = true,
            @Query("user_financial_details") userFinancial_Details: Boolean = true,
            @Query("user_location_details") userLocationDetails: Boolean = true,
            @Query("user_portfolio_details") userPortfolioDetails: Boolean = true,
            @Query("user_preferred_details") userPreferredDetails: Boolean = true,
            @Query("user_badge_details") userBadgeDetails: Boolean = true,
            @Query("user_status") userStatus: Boolean = true,
            @Query("user_reputation") userReputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_reputation_extra") userReputationExtra: Boolean = true,
            //FIXME These errors will currently cause a 500 (should actually be 400) from the api
//            @Query("user_employer_reputation_extra") userEmployerReputationExtra: Boolean = true,
//            @Query("user_cover_image") userCoverImage: Boolean = false,
//            @Query("user_past_cover_images") userPastCoverImages: Boolean = false,
            @Query("user_responsiveness") userResponsiveness: Boolean = true,
            @Query("corporate_users") corporateUsers: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int): Observable<ProjectListResponse>

    /**
     * TODO
     * Add endpoint to invite freelancers /projects/0.1/projects/{project_id}/invite
     */

    /**
     * TODO
     * Add endpoint to list upgrade fees /projects/0.1/projects/fees
     */

    @GET("projects/{project_id}/bids/")
    fun listProjectBids(@Path("project_id") projectId: Long,
            @Query("bidders[]") vararg bidders: Long,
            @Query("award_status_possibilities") award_status_possibilities: Boolean = true,
            @Query("user_reputation") reputation: Boolean = true,
            @Query("user_details") user_details: Boolean = true,
            @Query("user_avatar") user_avatar: Boolean = true,
            @Query("user_country_details") user_country_details: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_location_details") user_location_details: Boolean = true,
            @Query("user_badge_details") user_badge_details: Boolean = true,
            @Query("user_status") user_status: Boolean = true,
            @Query("buyer_project_fee") buyer_project_fee: Boolean = true,
            @Query("compact") compact: Boolean = true,
            @Query("user_reputation") user_reputation: Boolean = true): Observable<BidsResponse>

    @GET("projects/{project_id}/bidinfo/")
    fun getProjectBidInformation(@Path("project_id") projectId: Long): Observable<BidInfo>

    /**
     * TODO
     * Add endpoint to get project milestones /projects/0.1/{project_id}/milestones
     */

    /**
     * TODO
     * Add endpoint to get project milestone requests /projects/0.1/{project_id}/milestone_requests
     */

    @Multipart
    @PUT("projects/{project_id}/")
    fun addAttachment(@Path("project_id") projectId: Long,
            @Part("action") action: RequestBody,
            @Part attachment: MultipartBody.Part): Observable<AddAttachmentResponse>
}
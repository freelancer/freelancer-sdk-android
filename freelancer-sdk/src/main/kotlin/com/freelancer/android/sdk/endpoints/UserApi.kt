package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.FLUser
import com.freelancer.android.sdk.models.Reputation
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.DirectoryResponse
import com.freelancer.android.sdk.models.response.UsersResponse
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface UserApi {
    @GET("users/")
    fun listUsers(@Query("users[]") userIds: List<Long>,
            @Query("usernames[]") usernames: List<String>,
            @Query("avatar") avatar: Boolean = true,
            @Query("country_details") countryDetails: Boolean = true,
            @Query("profile_description") profileDescription: Boolean = true,
            @Query("display_info") displayInfo: Boolean = true,
            @Query("jobs") jobs: Boolean = true,
            @Query("balance_details") balanceDetails: Boolean = true,
            @Query("qualification_details") qualificationDetails: Boolean = true,
            @Query("membership_details") membershipDetails: Boolean = true,
            @Query("financial_details") financialDetails: Boolean = true,
            @Query("location_details") locationDetails: Boolean = true,
            @Query("portfolio_details") portfolioDetails: Boolean = true,
            @Query("preferred_details") preferredDetails: Boolean = true,
            @Query("badge_details") badgeDetails: Boolean = true,
            @Query("status") status: Boolean = true,
            @Query("reputation") reputation: Boolean = true,
            @Query("employer_reputation") employerReputation: Boolean = true,
            @Query("reputation_extra") reputationExtra: Boolean = true,
            @Query("employer_reputation_extra") employerReputationExtra: Boolean = true,
            @Query("cover_image") coverImage: Boolean = true,
            @Query("past_cover_images") pastCoverImages: Boolean = true,
            @Query("mobile_tracking") mobileTracking: Boolean = true,
            @Query("bid_quality_details") bidQualityDetails: Boolean = true): Observable<UsersResponse>

    @GET("users/{user_id}")
    fun getUserById(@Path("user_id") userId: Long): Observable<FLUser>

    @GET("users/directory")
    fun searchForFreelancers(@Query("jobs[]") jobIds: List<Long>? = null,
            @Query("countries[]") countries: List<String>? = null,
            @Query("username") username: String? = null,
            @Query("hourly_rate_min") hourlyRateMin: Int? = null,
            @Query("hourly_rate_max") hourlyRateMax: Int? = null,
            @Query("online_only") onlineOnly: Boolean = false,
            @Query("location_latitude") locationLatitude: Double? = null,
            @Query("location_longitude") locationLongitude: Double? = null,
            @Query("insignias[]") insignias: List<Long>? = null,
            @Query("ratings") ratings: Double? = null,
            @Query("avatar") avatar: Boolean = true,
            @Query("country_details") countryDetails: Boolean = true,
            @Query("profile_description") profileDescription: Boolean = true,
            @Query("display_info") displayInfo: Boolean = true,
            @Query("jobs") jobs: Boolean = true,
            @Query("balance_details") balanceDetails: Boolean = true,
            @Query("qualification_details") qualificationDetails: Boolean = true,
            @Query("membership_details") membershipDetails: Boolean = true,
            @Query("financial_details") financialDetails: Boolean = true,
            @Query("location_details") locationDetails: Boolean = true,
            @Query("portfolio_details") portfolioDetails: Boolean = true,
            @Query("preferred_details") preferredDetails: Boolean = true,
            @Query("badge_details") badgeDetails: Boolean = true,
            @Query("status") status: Boolean = true,
            @Query("reputation") reputation: Boolean = true,
            @Query("employer_reputation") employerReputation: Boolean = true,
            @Query("reputation_extra") reputationExtra: Boolean = true,
            @Query("employer_reputation_extra") employerReputationExtra: Boolean = true,
            @Query("cover_image") coverImage: Boolean = true,
            @Query("past_cover_images") pastCoverImages: Boolean = true,
            @Query("mobile_tracking") mobileTracking: Boolean = true,
            @Query("bid_quality_details") bidQualityDetails: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int,
            @Query("compact") compact: Boolean = true): Observable<DirectoryResponse>

    @GET("users/self/")
    fun getSelfUser(@Query("avatar") avatar: Boolean = true,
            @Query("country_details") countryDetails: Boolean = true,
            @Query("profile_description") profileDescription: Boolean = true,
            @Query("display_info") displayInfo: Boolean = true,
            @Query("jobs") jobs: Boolean = true,
            @Query("balance_details") balanceDetails: Boolean = true,
            @Query("qualification_details") qualificationDetails: Boolean = true,
            @Query("membership_details") membershipDetails: Boolean = true,
            @Query("financial_details") financialDetails: Boolean = true,
            @Query("location_details") locationDetails: Boolean = true,
            @Query("portfolio_details") portfolioDetails: Boolean = true,
            @Query("preferred_details") preferredDetails: Boolean = true,
            @Query("badge_details") badgeDetails: Boolean = true,
            @Query("status") status: Boolean = true,
            @Query("reputation") reputation: Boolean = true,
            @Query("employer_reputation") employerReputation: Boolean = true,
            @Query("reputation_extra") reputationExtra: Boolean = true,
            @Query("employer_reputation_extra") employerReputationExtra: Boolean = true,
            @Query("cover_image") coverImage: Boolean = true,
            @Query("past_cover_images") pastCoverImages: Boolean = true,
            @Query("mobile_tracking") mobileTracking: Boolean = true,
            @Query("bid_quality_details") bidQualityDetails: Boolean = true,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int,
            @Query("compact") compact: Boolean = true): Observable<FLUser>

    @FormUrlEncoded
    @POST("self/jobs")
    fun addToUser(@Field("jobs[]") jobs: List<Long>): Observable<ApiResponse>

    @FormUrlEncoded
    @PUT("self/jobs")
    fun setForUser(@Field("jobs[]") jobs: List<Long>): Observable<ApiResponse>

    @FormUrlEncoded
    @DELETE("self/jobs")
    fun deleteFromUser(@Field("jobs[]") jobs: List<Long>): Observable<ApiResponse>

    @GET("reputations")
    fun listUserReputation(@Query("users[]") userIds: List<Long>,
            @Query("jobs[]") jobIds: List<Long>? = null,
            @Query("role") role: FLUser.Role? = null,
            @Query("job_history") jobHistory: Boolean = true,
            @Query("project_stats") projectStats: Boolean = true,
            @Query("rehire_rates") rehireRates: Boolean = true): Observable<Reputation>

    /**
     * TODO add response for portfolios
     *
     * Blocked on api documentation - https://developers.freelancer.com/docs/users/portfolios#portfolios-get
     * Require schema
     */
//    @GET("portfolios")
//    fun listUserPortfolios(@Query("users[]") userIds: List<Long>,
//            @Query("limit") limit: Int,
//            @Query("offset") offset: Int): Observable<ApiResponse>
}
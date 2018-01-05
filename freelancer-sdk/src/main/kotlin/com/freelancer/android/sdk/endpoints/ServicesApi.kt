package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Service
import com.freelancer.android.sdk.models.response.ServiceListResponse
import com.freelancer.android.sdk.models.response.ServiceOrderResponse
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ServicesApi {

    @PUT("services/{service_type}/{service_id}/order/")
    fun orderService(
            @Path("service_type") serviceType: Service.Type,
            @Path("service_id") serviceId: Long,
            @Field("extras") extras: List<Long>
    ): Observable<ServiceOrderResponse>

    @GET("services/")
    fun listServices(
            @Query("services[]") services: List<Long>,
            @Query("owners[]") owners: List<Long>,
            @Query("statuses[]") statuses: List<Service.Status>,
            @Query("sub_statuses[]") subStatuses: List<String>,
            @Query("titles[]") titles: List<String>,
            @Query("seo_urls[]") seoUrls: List<String>,
            @Query("extra_details") extraDetails: Boolean,
            @Query("file_details") fileDetails: Boolean,
            @Query("job_details") jobDetails: Boolean,
            @Query("user_details") userDetails: Boolean,
            @Query("full_description") fullDescription: Boolean,
            @Query("user_avatar") userAvatar: Boolean,
            @Query("user_country_details") userCountryDetails: Boolean,
            @Query("user_profile_description") userProfileDescription: Boolean,
            @Query("user_display_info") userDisplayInfo: Boolean,
            @Query("user_jobs") userJobs: Boolean,
            @Query("user_balance_details") userBalanceDetails: Boolean,
            @Query("user_qualification_details") userQualificationDetails: Boolean,
            @Query("user_membership_details") userMembershipDetails: Boolean,
            @Query("user_financial_details") userFinancialDetails: Boolean,
            @Query("user_location_details") userLocationDetails: Boolean,
            @Query("user_portfolio_details") user_portfolio_details: Boolean,
            @Query("user_preferred_details") user_preferred_details: Boolean,
            @Query("user_badge_details") user_badge_details: Boolean,
            @Query("user_status") user_status: Boolean,
            @Query("user_reputation") user_reputation: Boolean,
            @Query("user_employer_reputation") user_employer_reputation: Boolean,
            @Query("user_reputation_extra") user_reputation_extra: Boolean,
            @Query("user_employer_reputation_extra") user_employer_reputation_extra: Boolean,
            @Query("user_cover_image") user_cover_image: Boolean,
            @Query("user_past_cover_images") user_past_cover_images: Boolean,
            @Query("user_responsiveness") user_responsiveness: Boolean,
            @Query("corporate_users") corporate_users: Boolean,
            @Query("limit") limit: Long,
            @Query("offset") offset: Long,
            @Query("compact") compact: Boolean
    ): Observable<ServiceListResponse>

    @GET("services/active/")
    fun listActiveServices(
            @Query("query") query: String,
            @Query("sort") sort: Service.Sort,
            @Query("reverse_sort") reverseSort: Boolean,
            @Query("statuses[]") statuses: List<Service.Status>,
            @Query("extra_details") extraDetails: Boolean,
            @Query("file_details") fileDetails: Boolean,
            @Query("job_details") jobDetails: Boolean,
            @Query("user_details") userDetails: Boolean,
            @Query("full_description") fullDescription: Boolean,
            @Query("offset") offset: Boolean,
            @Query("compact") compact: Boolean
    ): Observable<ServiceListResponse>
}

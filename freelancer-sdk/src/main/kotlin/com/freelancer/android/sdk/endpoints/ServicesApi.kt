package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Service
import com.freelancer.android.sdk.models.response.ServiceListResponse
import com.freelancer.android.sdk.models.response.ServiceOrderResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ServicesApi {

    @FormUrlEncoded
    @PUT("services/{service_type}/{service_id}/order/")
    fun orderService(
            @Path("service_type") serviceType: Service.Type,
            @Path("service_id") serviceId: Long,
            @Field("extras") extras: List<Long>? = null
    ): Observable<ServiceOrderResponse>

    @GET("services/")
    fun listServices(
            @Query("services[]") services: List<Long>? = null,
            @Query("owners[]") owners: List<Long>? = null,
            @Query("statuses[]") statuses: @JvmSuppressWildcards List<Service.Status>? = null,
            @Query("sub_statuses[]") subStatuses: List<String>? = null,
            @Query("titles[]") titles: List<String>? = null,
            @Query("seo_urls[]") seoUrls: List<String>? = null,
            @Query("extra_details") extraDetails: Boolean? = null,
            @Query("file_details") fileDetails: Boolean? = null,
            @Query("job_details") jobDetails: Boolean? = null,
            @Query("user_details") userDetails: Boolean? = null,
            @Query("full_description") fullDescription: Boolean? = null,
            @Query("user_avatar") userAvatar: Boolean? = null,
            @Query("user_country_details") userCountryDetails: Boolean? = null,
            @Query("user_profile_description") userProfileDescription: Boolean? = null,
            @Query("user_display_info") userDisplayInfo: Boolean? = null,
            @Query("user_jobs") userJobs: Boolean? = null,
            @Query("user_balance_details") userBalanceDetails: Boolean? = null,
            @Query("user_qualification_details") userQualificationDetails: Boolean? = null,
            @Query("user_membership_details") userMembershipDetails: Boolean? = null,
            @Query("user_financial_details") userFinancialDetails: Boolean? = null,
            @Query("user_location_details") userLocationDetails: Boolean? = null,
            @Query("user_portfolio_details") user_portfolio_details: Boolean? = null,
            @Query("user_preferred_details") user_preferred_details: Boolean? = null,
            @Query("user_badge_details") user_badge_details: Boolean? = null,
            @Query("user_status") user_status: Boolean? = null,
            @Query("user_reputation") user_reputation: Boolean? = null,
            @Query("user_employer_reputation") user_employer_reputation: Boolean? = null,
            @Query("user_reputation_extra") user_reputation_extra: Boolean? = null,
            @Query("user_employer_reputation_extra") user_employer_reputation_extra: Boolean? = null,
            @Query("user_cover_image") user_cover_image: Boolean? = null,
            @Query("user_past_cover_images") user_past_cover_images: Boolean? = null,
            @Query("user_responsiveness") user_responsiveness: Boolean? = null,
            @Query("corporate_users") corporate_users: Boolean? = null,
            @Query("limit") limit: Long? = null,
            @Query("offset") offset: Long? = null,
            @Query("compact") compact: Boolean? = null
    ): Observable<ServiceListResponse>

    @GET("services/active/")
    fun listActiveServices(
            @Query("query") query: String? = null,
            @Query("sort") sort: Service.Sort? = null,
            @Query("reverse_sort") reverseSort: Boolean? = null,
            @Query("statuses[]") statuses: @JvmSuppressWildcards List<Service.Status>? = null,
            @Query("extra_details") extraDetails: Boolean? = null,
            @Query("file_details") fileDetails: Boolean? = null,
            @Query("job_details") jobDetails: Boolean? = null,
            @Query("user_details") userDetails: Boolean? = null,
            @Query("full_description") fullDescription: Boolean? = null,
            @Query("offset") offset: Boolean? = null,
            @Query("compact") compact: Boolean? = null
    ): Observable<ServiceListResponse>
}

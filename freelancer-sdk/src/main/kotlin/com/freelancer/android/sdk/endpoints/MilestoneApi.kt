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
    fun getMilestonesByProjectId(@Query("projects[]") projectId: Long,
            @Query("users[]") userId: Long,
            @Query("user_avatar") user_avatar: Boolean = true,
            @Query("user_country_details") user_country_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_badge_details") user_badge_details: Boolean = true,
            @Query("user_status") user_status: Boolean = true,
            @Query("user_reputation") reputation: Boolean = true,
            @Query("user_employer_reputation") userEmployerReputation: Boolean = true,
            @Query("user_details") user_details: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_location_details") user_location_details: Boolean = true): Observable<MilestoneResponse>

    @POST("milestones")
    fun createMilestone(@Body createMilestoneRequest: CreateMilestoneRequest): Observable<Milestone>

    @PUT("milestones/{milestone_id}/")
    fun performMilestoneAction(@Path("milestone_id") milestoneRequestId: Long,
            @Query("action") action: Milestone.MilestoneAction,
            @Query("amount") amount: Float): Observable<ApiResponse>
}
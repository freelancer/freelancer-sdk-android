package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.FLUser
import com.freelancer.android.sdk.models.request.PostReviewRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.ReviewResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable

interface ReviewsApi {

    @POST("reviews")
    fun postProjectReview(@Body postReviewRequest: PostReviewRequest): Observable<ApiResponse>

    @GET("reviews")
    fun getReviews(@Query("from_users[]") fromUserIds: List<Long>,
            @Query("to_users[]") toUserIds: List<Long>,
            @Query("role") role: FLUser.Role,
            @Query("user_avatar") user_avatar: Boolean = true,
            @Query("user_country_details") user_country_details: Boolean = true,
            @Query("user_qualification_details") user_qualification_details: Boolean = true,
            @Query("user_badge_details") user_badge_details: Boolean = true,
            @Query("user_status") user_status: Boolean = true,
            @Query("reputation") reputation: Boolean = true,
            @Query("user_details") user_details: Boolean = true,
            @Query("user_balance_details") user_balance_details: Boolean = true,
            @Query("user_location_details") user_location_details: Boolean = true,
            @Query("project_details") project_details: Boolean = true): Observable<ReviewResponse>

    /**
     * TODO
     *
     * add endpoint for review actions
     * /project/0.1/reviews/{review_id}/{?action}
     */
}

package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.DEFAULT_LIMIT_VALUE
import com.freelancer.android.sdk.DEFAULT_OFFSET_VALUE
import com.freelancer.android.sdk.models.Contest
import com.freelancer.android.sdk.models.request.PostContestRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.ContestResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ContestApi {

    @POST("contests")
    fun createContest(@Body contest: PostContestRequest): Single<Contest>

    @PUT("contests/{contest_id}/?action=join")
    fun joinContest(@Path("contest_id") contestId: Long): Single<ApiResponse>

    @GET("contests?compact")
    fun getContests(
            @Query("owners[]") ownerId: Long,
            @Query("statuses[]") statuses: MutableList<Contest.Status>,
            @Query("limit") limit: Int = DEFAULT_LIMIT_VALUE,
            @Query("offset") offset: Int = DEFAULT_OFFSET_VALUE,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("upgrade_details") upgradeDetails: Boolean = true,
            @Query("entry_counts") entryCounts: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true): Single<ContestResponse>

    @GET("contests/{contest_id}/")
    fun getContestById(
            @Path("contest_id") contestId: Long,
            @Query("job_details") jobDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("upgrade_details") upgradeDetails: Boolean = true,
            @Query("entry_counts") entryCounts: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true): Single<ContestResponse>
}
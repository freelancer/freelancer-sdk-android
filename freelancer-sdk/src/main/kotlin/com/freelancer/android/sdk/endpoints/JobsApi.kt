package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Job
import com.freelancer.android.sdk.models.response.JobBundleCategoryResponse
import com.freelancer.android.sdk.models.response.JobBundleResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface JobsApi {
    @GET("jobs")
    fun getJobs(@Query("jobs[]") jobsList: List<Long>,
            @Query("categories[]") categoryIds: List<Long>? = null): Observable<List<Job>>

    @GET("job_bundles")
    fun getJobBundles(): Observable<JobBundleResponse>

    @GET("job_bundle_categories")
    fun getJobBundleCategories(): Observable<JobBundleCategoryResponse>
}

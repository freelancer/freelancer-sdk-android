package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Job
import com.freelancer.android.sdk.models.response.JobBundleCategoryResponse
import com.freelancer.android.sdk.models.response.JobBundleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsApi {
    @GET("jobs")
    fun getJobs(
            @Query("jobs[]") jobsList: List<Long>? = null,
            @Query("job_names[]") jobNames: List<String>? = null,
            @Query("seo_urls[]") seoUrls: List<String>? = null,
            @Query("categories[]") categoryIds: List<Long>? = null,
            @Query("only_local") onlyLocal: Boolean? = null,
            @Query("active_project_count_details") activeProjectCountDetails: Boolean? = null,
            @Query("seo_details") seoDetails: Boolean? = null,
            @Query("seo_country_name") seoCountryName: String? = null,
            @Query("lang") lang: String? = null
    ): Single<List<Job>>

    @GET("job_bundles")
    fun getJobBundles(
            @Query("job_bundles[]") jobBundles: List<Long>? = null,
            @Query("categories[]") categories: List<Long>? = null,
            @Query("lang") lang: String? = null
    ): Single<JobBundleResponse>

    @GET("job_bundle_categories")
    fun getJobBundleCategories(
            @Query("categories[]") categories: List<Long>? = null,
            @Query("job_bundle_details") jobBundleDetails: Boolean? = null,
            @Query("lang") lang: String? = null
    ): Single<JobBundleCategoryResponse>
}
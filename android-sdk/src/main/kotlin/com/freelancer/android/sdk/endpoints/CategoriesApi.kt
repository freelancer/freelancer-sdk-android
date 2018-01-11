package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.JobCategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface CategoriesApi {

    @GET("categories")
    fun getCategories(
            @Query("categories[]") vararg categoryId: Long,
            @Query("lang") lang: String = "en",
            @Query("job_details") showJobDetails: Boolean? = null,
            @Query("active_project_count_details") showProjectCount: Boolean? = null,
            @Query("seo_details") showSeoDetails: Boolean? = null
    ) : Observable<JobCategoryResponse>

}
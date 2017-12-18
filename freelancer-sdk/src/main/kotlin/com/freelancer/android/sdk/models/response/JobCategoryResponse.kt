package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Job
import com.freelancer.android.sdk.models.JobCategory
import com.google.gson.annotations.SerializedName

data class JobCategoryResponse(
        @SerializedName("jobs") val jobs: Map<Long, List<Job>>,
        @SerializedName("categories") val categories: List<JobCategory>
)
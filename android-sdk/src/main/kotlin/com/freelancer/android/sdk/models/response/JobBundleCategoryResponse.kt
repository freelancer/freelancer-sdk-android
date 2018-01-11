package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.JobBundleCategory
import com.google.gson.annotations.SerializedName

class JobBundleCategoryResponse(
        @SerializedName("job_bundle_categories") val bundleCategories: List<JobBundleCategory>
)

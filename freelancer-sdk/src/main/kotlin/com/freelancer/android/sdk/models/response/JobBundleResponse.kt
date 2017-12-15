package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.JobBundle
import com.google.gson.annotations.SerializedName

class JobBundleResponse (
        @SerializedName("job_bundles") val bundles: List<JobBundle>
)

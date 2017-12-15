package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class JobBundleCategory(
        @SerializedName("job_bundles")
        var jobBundles: List<JobBundle>? = emptyList(),

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("name")
        override var name: String? = null

) : JobContext
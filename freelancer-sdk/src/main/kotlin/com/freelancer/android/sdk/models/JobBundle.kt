package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class JobBundle(
        @SerializedName("jobs")
        var jobs: List<Long>? = emptyList(),

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("name")
        override var name: String? = null,

        @SerializedName("job_bundle_category_id")
        var categoryId: Long = 0

) : JobContext
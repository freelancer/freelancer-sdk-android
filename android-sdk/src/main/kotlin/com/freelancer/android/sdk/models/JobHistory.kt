package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class JobHistory(

        @SerializedName("count_other")
        var otherJobCount: Int = 0,

        @SerializedName("job_counts")
        var jobCounts: List<JobCount>? = null

) : FLObject
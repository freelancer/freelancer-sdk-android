package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Reputation(

        @SerializedName("last12months")
        var last12Month: Period? = null,

        @SerializedName("last3months")
        var last3Month: Period? = null,

        @SerializedName("entire_history")
        var entireHistory: Period? = null,

        @SerializedName("job_history")
        var jobHistory: JobHistory? = null,

        @SerializedName("earnings_score")
        var earningsScore: Float = 0.toFloat(),

        @SerializedName("project_stats")
        var projectStats: ProjectStats? = null

) : FLObject
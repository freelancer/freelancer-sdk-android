package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ProjectStats(

        @SerializedName("open")
        var open: Int = 0,

        @SerializedName("complete")
        var complete: Int = 0,

        @SerializedName("work_in_progress")
        var workInProgress: Int = 0

) : FLObject
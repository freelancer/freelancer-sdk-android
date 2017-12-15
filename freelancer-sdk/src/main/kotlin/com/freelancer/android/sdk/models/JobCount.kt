package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class JobCount(
        @SerializedName("count")
        var count: Int = 0,

        @SerializedName("job")
        var job: Job? = null
) : FLObject
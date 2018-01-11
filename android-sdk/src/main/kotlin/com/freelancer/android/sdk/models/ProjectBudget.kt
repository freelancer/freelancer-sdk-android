package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ProjectBudget(

        @SerializedName("minimum")
        var min: Double = 0.toDouble(),

        @SerializedName("maximum")
        var max: Double = 0.toDouble()

) : FLObject
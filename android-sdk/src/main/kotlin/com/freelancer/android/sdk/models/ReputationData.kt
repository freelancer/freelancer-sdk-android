package com.freelancer.android.sdk.models

import com.freelancer.android.sdk.models.request.ICategoryRatingRequest
import com.google.gson.annotations.SerializedName

data class ReputationData(

        @SerializedName("on_budget")
        var onBudget: Boolean = false,

        @SerializedName("on_time")
        var onTime: Boolean = false,

        @SerializedName("category_ratings")
        var categoryRating: ICategoryRatingRequest? = null

)
package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class RatingDetails(
        @SerializedName("category_ratings")
        var categoryRating: CategoryRating? = null,

        @SerializedName("on_time")
        var onTime: Boolean? = false,

        @SerializedName("on_budget")
        var onBudget: Boolean? = false
) : FLObject
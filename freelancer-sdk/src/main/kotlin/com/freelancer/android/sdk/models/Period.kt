package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Period(
        @SerializedName("overall")
        var overall: Float = 0.toFloat(),

        @SerializedName("completion_rate")
        var completionRate: Float = 0.toFloat(),

        @SerializedName("on_budget")
        var onBudget: Float = 0.toFloat(),

        @SerializedName("positive")
        var positive: Float = 0.toFloat(),

        @SerializedName("on_time")
        var onTime: Float = 0.toFloat(),

        @SerializedName("all")
        var projectCount: Int = 0,

        @SerializedName("reviews")
        var reviews: Int = 0,

        @SerializedName("category_ratings")
        var categoryRating: CategoryRating? = null,

        @SerializedName("rehire_rate")
        var rehireRate: Float = 0.toFloat()

) : FLObject {
    /**
     * @return `true` if this object holds valid data, `false` otherwise
     */
    fun hasValidData(): Boolean = categoryRating != null && categoryRating?.hasValidData() ?: false
}
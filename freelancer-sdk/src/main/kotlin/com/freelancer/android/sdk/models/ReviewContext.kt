package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ReviewContext(
        @SerializedName("review_type")
        var reviewType: ReviewType? = null,

        @SerializedName("context_id")
        var contextId: Long = 0,

        @SerializedName("context_name")
        var contextName: String? = null,

        @SerializedName("seo_url")
        var seoUrl: String? = null

) : FLObject {

    enum class ReviewType {
        PROJECT,
        CONTEST;

        override fun toString(): String = name.toLowerCase()
    }
}
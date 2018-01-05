package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName
import java.util.Locale

data class Service(
        @SerializedName("id")
        val id: Int,

        @SerializedName("user_id")
        val userId: Int,

        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("instructions")
        val instructions: String,

        @SerializedName("time_submitted")
        val timeSubmitted: Int,

        @SerializedName("time_closed")
        val timeClosed: Int,

        @SerializedName("base_duration")
        val baseDuration: Int,

        @SerializedName("base_cost")
        val baseCost: Double,

        @SerializedName("currency")
        val currency: Currency,

        @SerializedName("status")
        val status: Status,

        @SerializedName("sub_status")
        val subStatus: String,

        @SerializedName("deleted")
        val deleted: Boolean,

        @SerializedName("rating")
        val rating: Double,

        @SerializedName("rating_count")
        val ratingCount: Int,

        @SerializedName("editors_choice")
        val editorsChoice: Boolean

) : FLObject {

    enum class Type {
        REGULAR,

        LOCAL;

        override fun toString(): String = name.toLowerCase(Locale.US)
    }

    enum class Status {

        PENDING,

        ACTIVE,

        CLOSED;

        override fun toString(): String = name.toLowerCase(Locale.US)
    }

    enum class Sort {

        NEWEST,

        QUICKEST,

        RECOMMENDED;

        override fun toString(): String = name.toLowerCase(Locale.US)
    }
}


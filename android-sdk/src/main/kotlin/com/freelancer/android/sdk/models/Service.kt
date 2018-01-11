package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName
import java.util.Locale

data class Service(
        @SerializedName("id")
        val id: Long,

        @SerializedName("user_id")
        val userId: Long,

        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("instructions")
        val instructions: String,

        @SerializedName("time_submitted")
        val timeSubmitted: Long,

        @SerializedName("time_closed")
        val timeClosed: Long,

        @SerializedName("base_duration")
        val baseDuration: Long,

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
        val ratingCount: Long,

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


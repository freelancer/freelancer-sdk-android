package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class HourlyProjectInfo(

        @SerializedName("commitment")
        var commitment: TimeCommitment? = null,

        @SerializedName("duration_enum")
        var duration: ProjectDuration? = null

) : FLObject {
    enum class ProjectDuration {
        LESS_THAN_ONE_WEEK,
        ONE_TO_FOUR_WEEKS,
        ONE_TO_THREE_MONTHS,
        THREE_TO_SIX_MONTHS,
        ONGOING,
        UNSPECIFIED,
        UNKNOWN;

        override fun toString(): String = name.toLowerCase()
    }
}
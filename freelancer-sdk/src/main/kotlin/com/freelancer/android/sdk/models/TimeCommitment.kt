package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class TimeCommitment(

        @SerializedName("hours")
        var hours: Int = 0,

        @SerializedName("interval")
        var interval: TimeUnit? = null

) : FLObject {

    enum class TimeUnit {
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK,
        MONTH,
        YEAR,
        DECADE,
        CENTURY,
        MILLENIUM;

        override fun toString(): String = name.toLowerCase()
    }
}
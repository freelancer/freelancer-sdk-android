package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Timezone
import com.google.gson.annotations.SerializedName

data class TimezonesResponse(
        @SerializedName("timezones")
        val timezones: List<Timezone>
)

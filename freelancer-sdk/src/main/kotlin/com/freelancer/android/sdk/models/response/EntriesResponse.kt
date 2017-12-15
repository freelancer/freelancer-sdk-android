package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Entry
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class EntriesResponse(
        @SerializedName("entries")
        private val entries: List<Entry>,
        @SerializedName("users")
        private val users: Map<Long, FLUser>? = null
)
package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Contest
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class ContestResponse(
        @SerializedName("contests") val contests: List<Contest>,
        @SerializedName("users") private val usersMap: Map<Long, FLUser>? = null
)
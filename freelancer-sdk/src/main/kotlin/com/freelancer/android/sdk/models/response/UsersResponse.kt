package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class UsersResponse(
        @SerializedName("users")
        private val usersMap: Map<Long, FLUser>?
)
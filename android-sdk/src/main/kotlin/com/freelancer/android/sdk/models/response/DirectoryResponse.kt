package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class DirectoryResponse(
        @SerializedName("users")
        private val users: List<FLUser>
)
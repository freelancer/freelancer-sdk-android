package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.FLUser
import com.freelancer.android.sdk.models.Message
import com.freelancer.android.sdk.models.MessageThread
import com.freelancer.android.sdk.models.Project
import com.google.gson.annotations.SerializedName

data class ThreadsResponse(
        @SerializedName("context_details") val contextDetails: ContextDetails?,
        @SerializedName("threads") val threads: List<MessageThread>?,
        @SerializedName("users") val usersMap: Map<Long, FLUser>?,
        @SerializedName("messages") val messages: List<Message>? = null
) {

    data class ContextDetails(
            @SerializedName("projects") val projectMap: Map<Long, Project>?
    )

}
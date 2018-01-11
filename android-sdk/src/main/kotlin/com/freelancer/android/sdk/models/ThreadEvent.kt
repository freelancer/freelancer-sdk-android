package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ThreadEvent(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("thread_id")
        var threadId: Long = 0,

        @SerializedName("time_created")
        var timeCreated: Long = 0,

        @SerializedName("event_type")
        var eventType: Type? = null,

        var userId: Long = 0,

        var context: ThreadContext? = null

) : FLObject {

    enum class Type {
        JOIN_GROUP_CHAT, LEAVE_GROUP_CHAT
    }
}

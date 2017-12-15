package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ThreadInfo(

        @SerializedName("context")
        var context: ThreadContext? = null,

        @SerializedName("members")
        var memberIds: List<Long>? = null,

        @SerializedName("inactive_members")
        var inactiveMemberIds: List<Long>? = null,

        @SerializedName("thread_type")
        var type: ThreadType? = null,

        @SerializedName("time_created")
        var timeCreated: Long = 0,

        @SerializedName("owner")
        var ownerId: Long = 0,

        @SerializedName("message")
        var lastMessage: Message? = null,

        @SerializedName("write_privacy")
        var writePrivacy: PrivacyLevel? = null,

        @Transient var members: List<FLUser>? = null,

        @Transient var activeMembers: List<FLUser>? = null,

        @Transient var contextObject: FLObject? = null,

        @Transient var owner: FLUser? = null

) : FLObject {

    enum class ThreadType {
        PRIVATE_CHAT,
        GROUP,
        PCB,
        PRIMARY,
        SUPPORT_CHAT;

        override fun toString(): String = name.toLowerCase()
    }

    enum class PrivacyLevel {
        OWNER,
        MEMBERS,
        ALL,
        MINE,
        NONE,
        OWNER_AUTOCHAT;

        override fun toString(): String = name.toLowerCase()
    }

    /**
     * @param myServerId
     * *         The userId of the currently logged-in user
     * *
     * *
     * @return The best user to display to represent this mMessageThread
     */
    fun getBestDisplayUser(myServerId: Long): FLUser? {
        if (members == null || members?.isEmpty() ?: true) {
            return null
        }

        //If we get here, the current user must be the only one in our members list
        return members?.let { it.firstOrNull { it.serverId != myServerId } ?: it[0] }
    }
}
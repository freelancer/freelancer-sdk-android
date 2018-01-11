package com.freelancer.android.sdk.models

import com.freelancer.android.sdk.utils.join
import com.google.gson.annotations.SerializedName

data class MessageThread(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("folder")
        var folder: Folder? = null,

        @SerializedName("thread_events")
        var threadEvents: List<ThreadEvent>? = null,

        @SerializedName("message_unread_count")
        var unreadCount: Int = 0,

        @SerializedName("is_muted")
        var isMuted: Boolean = false,

        @SerializedName("is_read")
        var isRead: Boolean = false,

        @SerializedName("time_read")
        var timeRead: Long = 0,

        @SerializedName("time_updated")
        var timeUpdated: Long = 0,

        @SerializedName("message_count")
        var messageCount: Int = 0,

        @SerializedName("thread")
        var info: ThreadInfo? = null,

        @SerializedName("highlights")
        var highlights: List<Highlight>? = null,

        @SerializedName("attachments")
        var attachments: List<Attachment>? = null

) : FLObject {

    enum class Folder {
        INBOX, ARCHIVED, SENT, FREELANCER
    }

    var searchTerm: String? = null
        get() {
            field?.let {
                return field
            } ?: return generateSearchTerm()
        }

    private fun generateSearchTerm(): String {
        val searchList = ArrayList<String>()
        highlights?.let {
            for ((_, texts) in it) {
                texts?.mapTo(searchList) { it.replace('\n', ' ').trim() }
            }
            return " ".join(searchList)
        }
        return ""
    }

    val lastMessage: Message?
        get() = info?.let(ThreadInfo::lastMessage)

    fun getBestDisplayUser(myServerId: Long): FLUser? = info?.getBestDisplayUser(myServerId)

    val members: List<FLUser>?
        get() = info?.members

    val activeMembers: List<FLUser>?
        get() = info?.activeMembers

    val isGroupChat: Boolean
        get() = activeMembers?.size ?: 0 > MIN_CHAT_MEMBERS

    companion object {
        val MIN_CHAT_MEMBERS = 2
    }
}
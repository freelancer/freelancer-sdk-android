package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Message(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("time_created")
        var timeCreated: Long = 0,

        @SerializedName("thread_id")
        var threadId: Long = 0,

        @SerializedName("parent_id")
        var parentId: Long = 0,

        @SerializedName("remove_reason")
        var removeReason: RemovalReason? = null,

        @SerializedName("from_user")
        var fromUserId: Long = 0,

        @SerializedName("message")
        var message: String? = null,

        @SerializedName("message_source")
        var messageSource: SourceType? = null,

        @SerializedName("client_message_id")
        var clientId: String? = null,

        @Transient var fromUser: FLUser? = null,

        @Transient var sentStatus: SentStatus? = null,

        @Transient var messageThread: MessageThread? = null,

        @SerializedName("attachments")
        var attachments: List<Attachment>? = null

) : FLObject {

    @SerializedName("thread")
    var thread: MessageThread? = null

    enum class RemovalReason {
        CONTACTS, ADVERTISING, HARASSMENT, FAKE, NONFEATURED, OTHER
    }

    enum class SourceType {
        DEFAULT_MSG, BID, ADMIN, SMTP, IOS, HIREME
    }

    enum class SentStatus {
        SENDING, SENT, RETRYING, FAILED
    }

    fun hasServerId(): Boolean = serverId != 0L

    fun hasAttachments(): Boolean = attachments?.let { !it.isEmpty() } ?: false

    fun isEmpty(): Boolean = message?.isEmpty() ?: true && !hasAttachments()
}
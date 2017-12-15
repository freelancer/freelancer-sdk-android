package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class MilestoneRequest(

        @SerializedName(value = "id", alternate = arrayOf("requestId"))
        var serverId: Long = 0,

        @SerializedName("status")
        var status: MilestoneStatus? = null,

        @SerializedName(value = "bidder_id", alternate = arrayOf("sellerId"))
        var bidderId: Long = 0,

        @SerializedName(value = "time_requested", alternate = arrayOf("time"))
        var timeRequested: Long = 0,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName(value = "project_owner_id", alternate = arrayOf("accountId"))
        var projectOwnerId: Long = 0,

        @SerializedName(value = "bid_id", alternate = arrayOf("bidId"))
        var bidId: Long = 0,

        @SerializedName("currency")
        var currency: Currency? = null,

        @SerializedName("amount")
        var amount: Double = 0.toDouble(),

        @SerializedName("project_id")
        var projectId: Long = 0,

        var milestoneUser: FLUser? = null,

        var projectOwnerUser: FLUser? = null

) : BaseMilestone {

    enum class MilestoneStatus {
        DELETED,
        REJECTED,
        PENDING,
        CREATED,
        UNKNOWN;

        override fun toString(): String = name.toLowerCase()
    }

    override fun getMilestoneBidderId(): Long = bidderId

    override fun getMilestoneDescription(): String? = description

    override fun getMilestoneCurrency(): Currency? = currency

    override fun getMilestoneAmount(): Double = amount

    override fun getMilestoneTime(): Long = timeRequested

    override fun isReleased(): Boolean = false
}
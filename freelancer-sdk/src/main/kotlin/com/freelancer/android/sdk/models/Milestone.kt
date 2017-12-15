package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Milestone(

        @SerializedName("status")
        var status: MilestoneStatus? = null,

        @SerializedName("bidder_id")
        var bidderId: Long = 0,

        @SerializedName("is_from_prepaid")
        var isFromPrepaid: Boolean = false,

        @SerializedName("bid_id")
        var bidId: Long = 0,

        @SerializedName("dispute_id")
        var disputeId: Long = 0,

        @SerializedName("amount")
        var amount: Double = 0.toDouble(),

        @SerializedName("time_created")
        var timeCreated: Long = 0,

        @SerializedName("project_owner_id")
        var projectOwnerId: Long = 0,

        @SerializedName("currency")
        var currency: Currency? = null,

        @SerializedName("reason")
        var reason: MilestoneReason? = null,

        @SerializedName("other_reason")
        var description: String? = null,

        @SerializedName("project_id")
        var projectId: Long = 0,

        @SerializedName("transaction_id")
        var transactionId: Long = 0,

        var milestoneUser: FLUser? = null,

        var projectOwnerUser: FLUser? = null

) : BaseMilestone {

    enum class MilestoneStatus {
        DISPUTED,
        REQUESTED_RELEASE,
        PENDING,
        FROZEN,
        CLEARED,
        CANCELED,
        UNKNOWN;

        override fun toString(): String = name.toLowerCase()
    }

    enum class MilestoneReason {
        FULL_PAYMENT,
        PARTIAL_PAYMENT,
        TASK_DESCRIPTION,
        OTHER,
        PARTLY_PAYMENT;

        override fun toString(): String = name.toLowerCase()
    }

    enum class MilestoneAction {
        ACCEPT,
        REJECT,
        RELEASE,
        REQUEST_RELEASE,
        CANCEL;

        override fun toString(): String = name.toLowerCase()
    }

    fun getOtherReason(): String? = description

    fun setOtherReason(reason: String) {
        description = reason
    }

    override fun getMilestoneBidderId(): Long = bidderId

    override fun getMilestoneTime(): Long = timeCreated

    override fun getMilestoneDescription(): String? = description

    override fun getMilestoneCurrency(): Currency? = currency

    override fun getMilestoneAmount(): Double = amount

    override fun isReleased(): Boolean = status == MilestoneStatus.CLEARED
}
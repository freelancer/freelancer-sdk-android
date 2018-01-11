package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Bid(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName(value = "bidder_id", alternate = arrayOf("users_id"))
        var bidderId: Long = 0,

        @SerializedName("project_id")
        var projectId: Long = 0,

        @SerializedName("project_owner_id")
        var projectOwnerId: Long = 0,

        @SerializedName("retracted")
        var isRetracted: Boolean = false,

        @SerializedName("period")
        var period: Int = 0,

        @SerializedName("award_status")
        var awardStatus: BidStatus? = null,

        @SerializedName("complete_status")
        var bidCompleteStatus: BidCompleteStatus? = null,

        @SerializedName("frontend_bid_status")
        var frontendStatus: FrontendBidStatus? = null,

        @SerializedName("award_status_possibilities")
        var possibleStatuses: List<BidStatus>? = null,

        @SerializedName(value = "amount", alternate = arrayOf("sum"))
        var amount: Float = 0.toFloat(),

        @SerializedName(value = "description", alternate = arrayOf("descr"))
        var description: String? = null,

        @SerializedName("reputation")
        var reputation: Reputation? = null,

        @SerializedName("buyer_project_fee")
        var buyerProjectFee: ProjectFee? = null,

        @SerializedName("milestone_percentage")
        var milestonePercentage: Float = 0f,

        @SerializedName("highlighted")
        var isHighlighted: Boolean = false,

        @SerializedName("sponsored")
        var sponsoredAmount: Float = 0.toFloat(),

        @SerializedName(value = "time_submitted", alternate = arrayOf("submitdate_ts"))
        var timeSubmitted: Long = 0,

        @SerializedName("time_awarded")
        var timeAwarded: Long = 0,

        @SerializedName("bidder")
        var bidUser: FLUser? = null,

        @SerializedName("score")
        var score: Double? = null,

        var isRecommended: Boolean = false,

        @SerializedName("paid_status")
        var paidStatus: PaidStatus? = null

) : FLObject {

    enum class BidStatus {
        PENDING, AWARDED, REJECTED, REVOKED;

        override fun toString(): String = name.toLowerCase()
    }

    enum class BidCompleteStatus {
        PENDING, INCOMPLETE, COMPLETE;

        override fun toString(): String = name.toLowerCase()
    }

    enum class FrontendBidStatus {
        ACTIVE, IN_PROGRESS, COMPLETE;

        override fun toString(): String = name.toLowerCase()
    }

    enum class PaidStatus {
        UNPAID, FULLY_PAID, PARTLY_PAID;

        override fun toString(): String = name.toLowerCase()
    }

    enum class BidAction(internal val action: String) {
        AWARD("award"),
        REVOKE("revoke"),
        ACCEPT("accept"),
        REJECT("deny"),
        RETRACT("retract"),
        HIGHLIGHT("highlight"),
        SPONSOR("sponsor"),
        DENY("deny"),
        SHORTLIST("shortlist"),
        UNSHORTLIST("unshortlist")
    }

    val isSponsored: Boolean
        get() = sponsoredAmount > 0

    fun canBeAwarded(): Boolean = hasPossibleState(BidStatus.PENDING)

    fun canBeRevoked(): Boolean = hasPossibleState(BidStatus.REVOKED)

    fun canBeAccepted(): Boolean = hasPossibleState(BidStatus.AWARDED)

    fun canBeRejected(): Boolean = hasPossibleState(BidStatus.REJECTED)

    val isPending: Boolean
        get() = awardStatus == BidStatus.PENDING

    val isAwarded: Boolean
        get() = awardStatus == BidStatus.AWARDED

    val isCompleted: Boolean
        get() = bidCompleteStatus == BidCompleteStatus.COMPLETE

    val isFullyPaid: Boolean
        get() = paidStatus == PaidStatus.FULLY_PAID

    private fun hasPossibleState(status: BidStatus?): Boolean =
            possibleStatuses != null && status != null && possibleStatuses?.contains(status) ?: false

    companion object {

        private fun compareUsername(bid1: Bid, bid2: Bid): Int {
            val userName1 = bid1.bidUser?.userName
            val userName2 = bid2.bidUser?.userName
            userName1 ?: return 0
            userName2 ?: return 0
            return userName1.compareTo(userName2, true)
        }

        private fun compareAmount(bid1: Bid, bid2: Bid): Int {
            val difference = bid1.amount - bid2.amount
            return if (difference > 0) 1 else if (difference < 0) -1 else 0
        }

        private fun compareReputation(bid1: Bid, bid2: Bid): Int {
            val overall1 = bid1.reputation?.entireHistory?.overall
            val overall2 = bid2.reputation?.entireHistory?.overall

            overall1 ?: return 0
            overall2 ?: return 0

            val difference = overall2 - overall2
            return if (difference < 0) 1 else if (difference > 0) -1 else 0
        }

        private fun compareDuration(bid1: Bid, bid2: Bid): Int = bid1.period - bid2.period

        fun sortByUsername(): Comparator<Bid> =
                Comparator { bid1, bid2 -> compareUsername(bid1, bid2) }

        fun sortByAmount(): Comparator<Bid> {
            return Comparator { bid1, bid2 ->
                val amountCompared = compareAmount(bid1, bid2)
                if (amountCompared != 0) {
                    return@Comparator amountCompared
                }

                val reputationCompared = compareReputation(bid1, bid2)
                if (reputationCompared != 0) {
                    return@Comparator reputationCompared
                }

                val durationCompared = compareDuration(bid1, bid2)
                if (durationCompared != 0) {
                    return@Comparator durationCompared
                }

                compareUsername(bid1, bid2)
            }
        }

        fun sortByReputation(): Comparator<Bid> {
            return Comparator { bid1, bid2 ->
                val reputationCompared = compareReputation(bid1, bid2)
                if (reputationCompared != 0) {
                    return@Comparator reputationCompared
                }

                val amountCompared = compareAmount(bid1, bid2)
                if (amountCompared != 0) {
                    return@Comparator amountCompared
                }

                val durationCompared = compareDuration(bid1, bid2)
                if (durationCompared != 0) {
                    return@Comparator durationCompared
                }

                compareUsername(bid1, bid2)
            }
        }

        fun sortByDuration(): Comparator<Bid> {
            return Comparator { bid1, bid2 ->
                val durationCompared = compareDuration(bid1, bid2)
                if (durationCompared != 0) {
                    return@Comparator durationCompared
                }

                val amountCompared = compareAmount(bid1, bid2)
                if (amountCompared != 0) {
                    return@Comparator amountCompared
                }

                val reputationCompared = compareReputation(bid1, bid2)
                if (reputationCompared != 0) {
                    return@Comparator reputationCompared
                }

                compareUsername(bid1, bid2)
            }
        }
    }
}
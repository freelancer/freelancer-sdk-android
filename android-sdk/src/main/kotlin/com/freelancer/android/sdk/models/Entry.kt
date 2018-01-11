package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Entry(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("contest_id")
        var contestId: Long = 0,

        @SerializedName("contest_owner_id")
        var contestOwnerId: Long = 0,

        @SerializedName("owner_id")
        var ownerId: Long = 0,

        @SerializedName("status")
        var status: EntryStatus? = null,

        @SerializedName("number")
        var number: Int = 0,

        @SerializedName("title")
        var title: String? = null,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("upgrades")
        var upgrades: ContestUpgrades? = null,

        @SerializedName("files")
        var files: MutableList<EntryFile>? = null,

        @SerializedName("rating")
        var rating: Int = 0,

        @SerializedName("time_entered")
        var timeEntered: Long = 0,

        @SerializedName("time_eliminated")
        var timeEliminated: Long = 0,

        @SerializedName("time_won")
        var timeWon: Long = 0,

        @SerializedName("deleted")
        var deleted: Boolean = false,

        @SerializedName("like_count")
        var likeCount: Int = 0
) : FLObject {

    enum class EntryStatus {
        /**
         * Pending - this is only used for video entries, the entry is pending until we finish encoding their video
         */
        PENDING,

        /**
         * Withdrawn - this is when a freelancer withdraws his/her entry
         */
        WITHDRAWN,

        /**
         * Withdrawn Eliminated - withdrawn  + eliminated by contest holder
         */
        WITHDRAWN_ELIMINATED,

        /**
         * Eliminated - Entry was rejected by the contest holder
         */
        ELIMINATED,

        /**
         * Active - Entry is active and visible
         */
        ACTIVE,

        /**
         * Won - Entry has been awarded
         */
        WON,

        /**
         * Won Closed - Entry has been awarded and the prize has been released
         */
        WON_CLOSED,

        /**
         * Won Runner Up - WON_RUNNER_UP was created for specific contests
         */
        WON_RUNNER_UP,

        /**
         * Won Bronze - WON_BRONZE was created for specific contests.
         */
        WON_BRONZE,

        /**
         * Won Silver - WON_SILVER was created for specific contests.
         */
        WON_SILVER,

        /**
         * Chosen - Entry has been awarded on a design studio contest
         */
        CHOSEN,

        /**
         * Won Gold - WON_GOLD was created for specific contests
         */
        WON_GOLD,

        /**
         * Draft - Entry is still pending approval on our classifier or entry upgrades hasn't been paid for yet
         */
        DRAFT,

        /**
         * Bought - Entry was bought by contest holder
         */
        BOUGHT;

        override fun toString(): String = name.toLowerCase()
    }

    /**
     * Used in [com.freelancer.android.sdk.endpoints.EntriesApi.performEntryAction]
     */
    enum class Action {
        AWARD, REJECT;

        override fun toString(): String = name.toLowerCase()
    }

    fun isWinner(): Boolean = status == EntryStatus.WON || status == EntryStatus.WON_CLOSED

    fun isRejected(): Boolean = status == EntryStatus.ELIMINATED

    fun isWithdrawn(): Boolean =
            status == EntryStatus.WITHDRAWN || status == EntryStatus.WITHDRAWN_ELIMINATED
}
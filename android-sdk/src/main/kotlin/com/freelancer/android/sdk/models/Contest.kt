package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Contest(
        @SerializedName("id")
        override var serverId: Long = 0,

        @SerializedName("owner_id")
        override var ownerId: Long = 0,

        @SerializedName("title")
        override var title: String? = null,

        @SerializedName("seo_url")
        var seoUrl: String? = null,

        @SerializedName("currency")
        var currency: Currency? = null,

        @SerializedName("time_submitted")
        var timeSubmitted: Long = 0,

        @SerializedName("prize")
        var prize: Double = 0.toDouble(),

        @SerializedName("jobs")
        var jobs: List<Job>? = null,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("status")
        var status: Status? = null,

        @SerializedName("locked")
        var isLocked: Boolean = false,

        @SerializedName("duration")
        var duration: Long = 0,

        @SerializedName("type")
        var type: Type? = null,

        @SerializedName("time_posted")
        var timePosted: Long = 0,

        @SerializedName("time_ended")
        var timeEnded: Long = 0,

        @SerializedName("time_modified")
        var timeModified: Long = 0,

        @SerializedName("deleted")
        var isDeleted: Boolean = false,

        @SerializedName("time_locked")
        var timeLocked: Long = 0,

        @SerializedName("language")
        var language: String? = null,

        @SerializedName("upgrades")
        var upgrades: ContestUpgrades? = null,

        @SerializedName("files")
        var contestFiles: List<ContestFile>? = null,

        @SerializedName("extended")
        var extended: String? = null,

        @SerializedName("entry_count")
        var entryCount: Int = 0
) : FLContext {

    enum class Type {
        REGULAR,
        PREPAID,
        GUARANTEED,
        FREEMIUM;

        override fun toString(): String = this.name.toLowerCase()
    }

    enum class Status {
        /**
         * Drafts
         */
        INACTIVE,
        ACTIVE,
        PENDING,
        CLOSED,
        /**
         * Deprecated
         */
        ACTIVE_NOT_EXPIRED;

        override fun toString(): String = this.name.toLowerCase()
    }

    companion object {
        fun sortByTimeSubmited(): Comparator<Contest> {
            return Comparator { contest, contest2 ->
                when {
                    contest.timeSubmitted == contest2.timeSubmitted -> 0
                    contest.timeSubmitted > contest2.timeSubmitted -> -1
                    else -> 1
                }
            }
        }

        fun sortByTimeModified(): Comparator<Contest> {
            return Comparator { contest, contest2 ->
                when {
                    contest.timeModified == contest2.timeModified -> 0
                    contest.timeModified > contest2.timeModified -> -1
                    else -> 1
                }
            }
        }

        fun sortByPrize(): Comparator<Contest> {
            return Comparator { contest, contest2 ->
                when {
                    contest.prize == contest2.prize -> 0
                    contest.prize > contest2.prize -> -1
                    else -> 1
                }
            }
        }

        fun sortByDuration(): Comparator<Contest> {
            return Comparator { contest, contest2 ->
                when {
                    contest.duration == contest2.duration -> 0
                    contest.duration > contest2.duration -> -1
                    else -> 1
                }
            }
        }

        fun sortByEntryCount(): Comparator<Contest> {
            return Comparator { contest, contest2 ->
                when {
                    contest.entryCount == contest2.entryCount -> 0
                    contest.entryCount > contest2.entryCount -> -1
                    else -> 1
                }
            }
        }
    }
}
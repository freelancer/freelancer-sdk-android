package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName
import java.util.Locale

data class Project(

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

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("jobs")
        var jobs: List<Job>? = null,

        @SerializedName("preview_description")
        var previewDescription: String? = null,

        @SerializedName("deleted")
        var isDeleted: Boolean = false,

        @SerializedName("type")
        var type: ProjectType? = null,

        @SerializedName("bidperiod")
        var bidPeriod: Int = 0,

        @SerializedName("budget")
        var budget: ProjectBudget? = null,

        @SerializedName("bid_stats")
        var bidStats: BidStats? = null,

        @SerializedName("time_submitted")
        var timeSubmitted: Long = 0,

        @SerializedName("time_updated")
        var timeUpdated: Long = 0,

        @SerializedName("upgrades")
        var upgrades: ProjectUpgrades? = null,

        @SerializedName("language")
        var language: String? = null,

        @SerializedName("hireme")
        var isHireMe: Boolean = false,

        @SerializedName("frontend_project_status")
        var projectFrontendStatus: FrontendProjectStatus? = null,

        @SerializedName("location")
        var location: Location? = null,

        @SerializedName("local")
        var isLocal: Boolean = false,

        @SerializedName("negotiated")
        var negotiated: Boolean = false,

        @SerializedName("time_free_bids_expire")
        var timeFreeBidsExpire: Long = 0,

        @SerializedName("owner")
        var owner: FLUser? = null

        /**
         * TODO
         *
         * Add Support Session Details
         *
         */

) : FLContext {

    enum class FrontendProjectStatus {

        /** PENDING  */
        PENDING,

        /** ACTIVE or FROZEN  */
        OPEN,

        /** Has a selected freelancer/s */
        WORK_IN_PROGRESS,

        /** COMPLETE  */
        COMPLETE;

        override fun toString(): String = name.toLowerCase(Locale.US)
    }

    enum class ProjectType {
        @SerializedName("fixed")
        FIXED,
        @SerializedName("hourly")
        HOURLY;

        override fun toString(): String = name.toLowerCase(Locale.US)
    }
}
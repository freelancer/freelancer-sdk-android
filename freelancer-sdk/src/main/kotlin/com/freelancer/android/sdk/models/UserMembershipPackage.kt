package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class UserMembershipPackage(

        @SerializedName("job_change_limit")
        var jobChangeLimit: Int = 0,

        @SerializedName("job_limit")
        var jobLimit: Int = 0,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("time_bid_refreshed")
        var timeBidRefreshed: Int = 0,

        @SerializedName("service_posting_limit")
        var servicePostingLimit: Int = 0,

        @SerializedName("id")
        var id: Int = 0,

        @SerializedName("bid_refresh_rate")
        var bidRefreshRate: Float = 0.toFloat()

) : FLObject
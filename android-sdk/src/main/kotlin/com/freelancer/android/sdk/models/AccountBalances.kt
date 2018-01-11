package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class AccountBalances(

        @SerializedName("job_changes_remaining")
        var jobChangesRemaining: Int = 0,

        @SerializedName("jobs_remaining")
        var jobsRemaining: Int = 0,

        @SerializedName("bids_remaining")
        var bidsRemaining: Int = 0,

        @SerializedName("service_postings_remaining")
        var servicePostingsRemaining: Int = 0,

        @SerializedName("balances")
        var balances: List<Balance>? = null

) : FLObject
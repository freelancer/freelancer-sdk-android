package com.freelancer.android.sdk.models.request

import com.freelancer.android.sdk.models.Contest
import com.freelancer.android.sdk.models.ContestUpgrades
import com.google.gson.annotations.SerializedName

data class PostContestRequest(
        val title: String,
        val prize: Double,
        val duration: Int,
        val type: Contest.Type,
        @SerializedName("currency_id")
        val currencyId: Int,
        @SerializedName("owner_id")
        var ownerId: Int? = null,
        var description: String? = null,
        @SerializedName("job_ids")
        var jobIds: List<Long>? = null,
        val language: String? = null,
        val upgrades: ContestUpgrades? = null,
        @SerializedName("job_bundle_category_id")
        val jobBundleCategoryId: Long? = null,
        @SerializedName("job_bundle_id")
        val jobBundleId: Long? = null,
        @SerializedName("draft")
        val draft: Boolean? = null
)
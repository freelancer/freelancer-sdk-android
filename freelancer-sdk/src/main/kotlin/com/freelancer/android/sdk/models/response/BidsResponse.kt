package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Bid
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

data class BidsResponse(
        @SerializedName("bids") val bids: List<Bid>,
        @SerializedName("users") val usersMap: Map<Long, FLUser>?,
        @SerializedName("recommended_bid") val recommendedBid: Bid?
)

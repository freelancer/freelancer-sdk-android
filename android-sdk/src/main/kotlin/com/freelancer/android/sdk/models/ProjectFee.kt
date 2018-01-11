package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ProjectFee(

        @SerializedName("is_taxed")
        var isTaxed: Boolean = false,

        @SerializedName("amount")
        var amount: Float = 0.toFloat(),

        @SerializedName("currency")
        var currency: Currency? = null

) : FLObject
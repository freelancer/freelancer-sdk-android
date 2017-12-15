package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Balance(

        @SerializedName("currency")
        var currency: Currency? = null,

        @SerializedName("amount")
        var amount: Float = 0.toFloat(),

        var ownerId: Long = 0

) : FLObject {

    val amountToString: String
        get() = currency?.format(amount) ?: ""
}
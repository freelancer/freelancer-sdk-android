package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Currency
import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
        @SerializedName("currencies") val currencies: List<Currency>
)
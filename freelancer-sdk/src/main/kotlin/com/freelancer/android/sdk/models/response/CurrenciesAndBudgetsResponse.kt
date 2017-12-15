package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Currency
import com.freelancer.android.sdk.models.PostProjectBudget
import com.google.gson.annotations.SerializedName

data class CurrenciesAndBudgetsResponse(
        @SerializedName("currencies")
        val currencies: HashMap<Long, Currency>,

        @SerializedName("budgets")
        val budgets: List<PostProjectBudget>

)
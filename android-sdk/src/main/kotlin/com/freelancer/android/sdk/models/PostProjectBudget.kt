package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class PostProjectBudget(

        @SerializedName("currency_id")
        var currencyId: Long = 0,

        @SerializedName("minimum")
        var minimum: Double = 0.toDouble(),

        @SerializedName("maximum")
        var maximum: Double = 0.toDouble(),

        @SerializedName("project_type")
        var projectType: Project.ProjectType? = null,

        @SerializedName("name")
        var name: String? = null

) : FLObject {

    fun getAsAnswerText(currency: Currency, withCodeAppended: Boolean = false): String {
        if (withCodeAppended) {
            if (minimum == maximum) {
                return String.format("%s %s %s", currency.sign, BigDecimal(minimum), currency.code)
            } else if (maximum == 0.0) {
                return String.format("%s %s %s +", currency.sign, BigDecimal(minimum), currency.code)
            } else {
                return String.format("%s %s - %s %s", currency.sign, BigDecimal(minimum), BigDecimal(maximum), currency.code)
            }
        } else {
            if (minimum == maximum) {
                return String.format("%s %s", currency.sign, BigDecimal(minimum))
            } else if (maximum == 0.0) {
                return String.format("%s %s +", currency.sign, BigDecimal(minimum))
            } else {
                return String.format("%s %s - %s", currency.sign, BigDecimal(minimum), BigDecimal(maximum))
            }
        }

    }

    fun generateBudget(): ProjectBudget {
        val budget = ProjectBudget()
        budget.min = minimum
        budget.max = maximum
        return budget
    }

    fun sortByMinimum(): Comparator<PostProjectBudget> {
        return Comparator { budget1, budget2 ->
            when {
                budget1.minimum == budget2.minimum -> 0
                budget1.minimum > budget2.minimum -> 1
                else -> -1
            }
        }
    }

}
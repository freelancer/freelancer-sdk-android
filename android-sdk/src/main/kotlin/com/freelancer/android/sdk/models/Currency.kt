package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName
import java.text.NumberFormat
import java.text.ParseException

data class Currency(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("code")
        var code: String? = null,

        @SerializedName("sign")
        var sign: String? = null,

        @SerializedName("exchange_rate")
        var exchangeRate: Float = 0.toFloat(),

        @SerializedName("country")
        var country: String? = null,

        @SerializedName("name")
        var name: String? = null,

        var budgets: MutableList<PostProjectBudget>? = null

) : FLObject {

    fun format(amount: Float): String = format(amount.toDouble())

    fun format(amount: Double, excludeDecimalPlace: Boolean = true): String =
            sign + formatAmountOnly(amount, excludeDecimalPlace) + " " + code

    companion object {

        const val DEFAULT_CURRENCY_CODE = "USD"
        const val DEFAULT_CURRENCY_SIGN = "$"
        val DEFAULT_CURRENCY = Currency(code = DEFAULT_CURRENCY_CODE, sign = DEFAULT_CURRENCY_SIGN)

        private var CURRENCY_FORMAT: NumberFormat = NumberFormat.getInstance()

        init {
            initializeCurrencyFormatter()
        }

        internal fun initializeCurrencyFormatter() {
            CURRENCY_FORMAT = NumberFormat.getInstance()
            CURRENCY_FORMAT.minimumFractionDigits = 2
            CURRENCY_FORMAT.minimumIntegerDigits = 1
            CURRENCY_FORMAT.maximumFractionDigits = 2
            CURRENCY_FORMAT
        }

        fun formatAmountOnly(amount: Float): String = formatAmountOnly(amount.toDouble())

        fun formatAmountOnly(amount: Double, excludeDecimalPlace: Boolean = true): String {
            return CURRENCY_FORMAT.format(amount).apply {
                if (excludeDecimalPlace) {
                    replace(".00", "")
                }
            }
        }

        /**
         * Remove commas in the number
         */
        fun formatAmountOnlyNoGroupings(amount: Double, withGroupings: Boolean = false): String {
            CURRENCY_FORMAT.isGroupingUsed = withGroupings
            val formatted = formatAmountOnly(amount)
            CURRENCY_FORMAT.isGroupingUsed = true
            return formatted
        }

        /** Formats an amount to the correct number of decimal places  */
        fun formatAmount(amount: Float): String {
            CURRENCY_FORMAT.isGroupingUsed = false
            var formatted = amount.toString()
            try {
                formatted = CURRENCY_FORMAT.format(amount.toDouble()).replace(".00", "")
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            CURRENCY_FORMAT.isGroupingUsed = true

            return formatted
        }
    }
}

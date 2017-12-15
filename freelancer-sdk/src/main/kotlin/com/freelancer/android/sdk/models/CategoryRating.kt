package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class CategoryRating(

        @SerializedName("communication")
        var communication: Float = 0.toFloat(),

        @SerializedName("professionalism")
        var professionalism: Float = 0.toFloat(),

        /**
         *  fromUser = EMPLOYER
         *  toUser = FREELANCER
         *  role to send = FREELANCER
         */
        @SerializedName("hire_again")
        var hireAgain: Float = 0.toFloat(),

        @SerializedName("expertise")
        var expertise: Float = 0.toFloat(),

        @SerializedName("quality")
        var quality: Float = 0.toFloat(),

        /**
         * fromUser = FREELANCER
         * toUser = EMPLOYER
         * role to send = EMPLOYER
         */
        @SerializedName("clarity_spec")
        var claritySpec: Float = 0.toFloat(),

        @SerializedName("payment_prom")
        var paymentPrompt: Float = 0.toFloat(),

        @SerializedName("work_for_again")
        var workForAgain: Float = 0.toFloat()

) : FLObject {
    fun hasValidData(): Boolean {
        return professionalism != 0f || quality != 0f ||
                hireAgain != 0f || communication != 0f ||
                expertise != 0f || claritySpec != 0f ||
                paymentPrompt != 0f || workForAgain != 0f
    }
}
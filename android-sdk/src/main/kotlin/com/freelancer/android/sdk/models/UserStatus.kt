package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class UserStatus(

        @SerializedName("email_verified")
        var isEmailVerified: Boolean = false,

        @SerializedName("payment_verified")
        var isPaymentVerified: Boolean = false,

        @SerializedName("deposit_made")
        var isDepositMade: Boolean = false,

        @SerializedName("phone_verified")
        var isPhoneVerified: Boolean = false,

        @SerializedName("profile_complete")
        var isProfileComplete: Boolean = false

) : FLObject
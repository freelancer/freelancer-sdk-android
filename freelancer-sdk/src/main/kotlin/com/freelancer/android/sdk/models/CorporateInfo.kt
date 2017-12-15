package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class CorporateInfo(

        @SerializedName("status")
        var status: String? = null,

        @SerializedName("founder_id")
        var founderId: Long = 0

) : FLObject
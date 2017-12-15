package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Country(

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("code")
        var code: String? = null,

        @SerializedName("flag_url")
        var flag: String? = null,

        @SerializedName("highres_flag_url")
        var highResFlag: String? = null

) : FLObject
package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Timezone (
        @SerializedName("id")
        var id: Int = 0,

        @SerializedName("country")
        var country: String? = null,

        @SerializedName("timezone")
        var timezone: String? = null,

        @SerializedName("offset")
        var offset: Float = 0.toFloat()
) : FLObject {

    override fun toString(): String = timezone ?: ""
}
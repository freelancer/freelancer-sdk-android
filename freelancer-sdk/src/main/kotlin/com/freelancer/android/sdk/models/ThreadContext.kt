package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class ThreadContext(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("type")
        var type: Type? = null

) : FLObject {

    enum class Type {
        NONE, PROJECT, CONTEST, SUPPORT_CHAT
    }
}
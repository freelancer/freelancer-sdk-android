package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Entry
import com.google.gson.annotations.SerializedName

data class EntryResponse(
        @SerializedName("entry") val entry: Entry
)
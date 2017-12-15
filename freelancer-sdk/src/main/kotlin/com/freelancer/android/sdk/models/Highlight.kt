package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class Highlight(
        @SerializedName("field") val field: String?,
        @SerializedName("highlighted_text") val texts: List<String>?
)
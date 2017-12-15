package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class CoverImage(

        @SerializedName("current_image")
        var currentImage: Image? = null,

        @SerializedName("past_images")
        var pastImages: List<Image>? = null

) : FLObject
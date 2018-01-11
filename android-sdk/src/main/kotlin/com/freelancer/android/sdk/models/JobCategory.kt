package com.freelancer.android.sdk.models

import com.freelancer.android.sdk.translations.ITranslation
import com.freelancer.android.sdk.translations.TranslationList
import com.freelancer.android.sdk.translations.translate
import com.google.gson.annotations.SerializedName

data class JobCategory(

        @SerializedName("id")
        val serverId: Long = 0,

        @SerializedName("name")
        override var name: String? = null

) : JobContext, ITranslation {

    override fun translate(translations: TranslationList) {
        name = translations.translate(name)
    }

}
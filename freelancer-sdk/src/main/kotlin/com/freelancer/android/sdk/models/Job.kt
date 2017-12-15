package com.freelancer.android.sdk.models

import com.freelancer.android.sdk.translations.ITranslation
import com.freelancer.android.sdk.translations.TranslationList
import com.freelancer.android.sdk.translations.translate
import com.google.gson.annotations.SerializedName

data class Job(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("name")
        override var name: String? = null,

        @SerializedName("category")
        var category: JobCategory? = null,

        @SerializedName("active_project_count")
        var activeProjectCount: Int = 0,

        @SerializedName("local")
        var local: Boolean = false

) : JobContext, ITranslation {

    override fun translate(translations: TranslationList) {
        name = translations.translate(name)
        category?.translate(translations)
    }
}

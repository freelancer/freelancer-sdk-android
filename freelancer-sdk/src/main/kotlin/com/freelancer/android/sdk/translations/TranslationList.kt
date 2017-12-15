package com.freelancer.android.sdk.translations

class TranslationList {

    private val _translatedStrings = HashMap<String, String>()

    fun add(key: String, value: String) {
        _translatedStrings.put(key, value)
    }

    fun add(map: HashMap<String, String>) {
        _translatedStrings.putAll(map)
    }

    fun add(translationList: TranslationList) {
        _translatedStrings.putAll(translationList.translatedStrings)
    }

    operator fun get(key: String): String? = _translatedStrings[key]

    val translatedStrings: Map<String, String>
        get() = _translatedStrings

}
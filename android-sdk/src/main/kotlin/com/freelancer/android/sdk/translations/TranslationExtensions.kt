package com.freelancer.android.sdk.translations

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun TranslationList.translate(str: String?): String? {
    str?.let {
        val key = convertToMd5Hash(str)
        key?.let {
            val translated = get(key)
            if (translated != null) {
                return translated
            }
        }
    }
    return str
}

private fun convertToMd5Hash(str: String): String? {
    try {
        val md = MessageDigest.getInstance("MD5")
        val hash = md.digest(str.toByteArray())

        val hexString = StringBuffer()
        for (i in hash.indices) {
            var h = Integer.toHexString(0xFF and hash[i].toInt())
            while (h.length < 2)
                h = "0" + h
            hexString.append(h)
        }
        return hexString.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return null
}
package com.freelancer.android.sdk.utils

internal fun Boolean?.getInt(): Int {
    return if (this == null || !this) {
        0
    } else {
        1
    }
}

internal fun String.join(tokens: Iterable<*>): String {
    val sb = StringBuilder()
    var firstTime = true
    for (token in tokens) {
        if (firstTime) {
            firstTime = false
        } else {
            sb.append(this)
        }
        sb.append(token)
    }
    return sb.toString()
}
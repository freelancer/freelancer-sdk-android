package com.freelancer.android.sdk.utils

internal fun Boolean?.getInt(): Int {
    if (this == null || !this) {
        return 0
    } else {
        return 1
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
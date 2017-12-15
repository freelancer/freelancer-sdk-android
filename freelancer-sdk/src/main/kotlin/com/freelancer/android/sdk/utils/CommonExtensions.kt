package com.freelancer.android.sdk.utils

fun Boolean?.getInt(): Int {
    if (this == null || !this) {
        return 0
    } else {
        return 1
    }
}

fun String.join(tokens: Iterable<*>): String {
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
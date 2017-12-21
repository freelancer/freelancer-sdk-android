package com.freelancer.android.sdk.utils

import android.content.Context
import com.freelancer.android.sdk.models.Attachment
import java.io.InputStream

/**
 * Created by arranlomas on 21/12/17.
 */
internal fun Attachment.toByteArray(context: Context): ByteArray {
    uri?.let {
        try {
            val inputStream: InputStream = context.contentResolver.openInputStream(it)
            val buffer = kotlin.ByteArray(inputStream.available())
            while (inputStream.read(buffer) != -1) {
            }
            return buffer
        } catch (e: OutOfMemoryError) {
            throw OutOfMemoryException()
        }
    }
    return kotlin.ByteArray(0)
}
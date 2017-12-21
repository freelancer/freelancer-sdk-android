package com.freelancer.android.sdk.utils

import android.content.Context
import android.webkit.MimeTypeMap
import com.freelancer.android.sdk.models.Attachment
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

/**
 * Created by arranlomas on 21/12/17.
 */
internal fun String.toRequestBody(): RequestBody {
    return RequestBody.create(MediaType.parse("text/plain"), this)
}

internal fun Long.toRequestBody(): RequestBody {
    return this.toString().toRequestBody()
}

internal fun List<Long>.toRequestBody(): RequestBody {
    return this.toString().toRequestBody()
}

internal fun <T : Enum<T>> T.toRequestBody(): RequestBody {
    return this.toString().toRequestBody()
}

internal fun List<Attachment>.toMultipart(context: Context): List<MultipartBody.Part> {
    return this.map {
        val extension = MimeTypeMap.getFileExtensionFromUrl(it.name)
        var mimeType = ""
        extension?.let {
            mimeType = extension
        }
        MultipartBody.Part.createFormData("files[]", it.name,
                RequestBody.create(MediaType.parse(mimeType), it.toByteArray(context)))
    }
}
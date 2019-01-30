package com.freelancer.android.sdk.models.request

import android.content.Context
import android.webkit.MimeTypeMap
import com.freelancer.android.sdk.models.Attachment
import com.freelancer.android.sdk.models.ThreadContext
import com.freelancer.android.sdk.models.ThreadInfo
import com.freelancer.android.sdk.utils.OutOfMemoryException
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.BufferedSink
import java.io.InputStream

/**
 * Created by arranlomas on 22/12/17.
 */
//members: List<Long>,
//contextType: ThreadContext.Type,
//threadContext: Long,
//message: String,
//files: List<Attachment>?,
//type: ThreadInfo.ThreadType,
//androidContext: Context
private val StringMediaType = MediaType.parse("text/plain")

data class MembersRequest(private val members: List<Long>)
    : BaseCreateThreadMultipartBody<Long>(members, { it.toString().toMultipart("members[]") })

data class ContextTypeRequest(private val contextType: ThreadContext.Type)
    : BaseCreateThreadRequestBody<ThreadContext.Type>(contextType, StringMediaType)

data class ThreadContextRequest(private val threadContext: Long)
    : BaseCreateThreadRequestBody<Long>(threadContext, StringMediaType)

data class MessageRequest(private val message: String)
    : BaseCreateThreadRequestBody<String>(message, StringMediaType)

data class FilesRequest(private val files: List<Attachment>, private val context: Context)
    : BaseCreateThreadMultipartBody<Attachment>(files, { it.toMultipart(context, "files[]") })

data class TypeRequest(private val type: ThreadInfo.ThreadType)
    : BaseCreateThreadRequestBody<ThreadInfo.ThreadType>(type, StringMediaType)

data class ClientMessageIdRequest(private val clientId: String)
    : BaseCreateThreadRequestBody<String>(clientId, StringMediaType)

open class BaseCreateThreadRequestBody<out T>(private val item: T, private val mediaType: MediaType?) : RequestBody() {
    override fun contentType(): MediaType? {
        return mediaType
    }

    override fun writeTo(sink: BufferedSink?) {
        sink?.write(item.toString().toByteArray())
    }
}

open class BaseCreateThreadMultipartBody<in T>(items: List<T>, private val mapMethod: (T) -> MultipartBody.Part) : List<MultipartBody.Part> {
    var elements: List<MultipartBody.Part> = items.map {
        mapMethod.invoke(it)
    }
    override val size: Int
        get() = elements.size

    override fun contains(element: MultipartBody.Part): Boolean {
        return elements.contains(element)
    }

    override fun containsAll(elements: Collection<MultipartBody.Part>): Boolean {
        return this.elements.containsAll(elements)
    }

    override fun get(index: Int): MultipartBody.Part {
        return elements[index]
    }

    override fun indexOf(element: MultipartBody.Part): Int {
        return elements.indexOf(element)
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun iterator(): Iterator<MultipartBody.Part> {
        return elements.iterator()
    }

    override fun lastIndexOf(element: MultipartBody.Part): Int {
        return elements.lastIndexOf(element)
    }

    override fun listIterator(): ListIterator<MultipartBody.Part> {
        return elements.listIterator()
    }

    override fun listIterator(index: Int): ListIterator<MultipartBody.Part> {
        return elements.listIterator(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<MultipartBody.Part> {
        return elements.subList(fromIndex, toIndex)
    }
}

private fun Attachment.toMultipart(context: Context, formDataName: String): MultipartBody.Part {
    val extension = MimeTypeMap.getFileExtensionFromUrl(name)
    var mimeType = ""
    extension?.let {
        mimeType = extension
    }
    return MultipartBody.Part.createFormData(formDataName, name,
            RequestBody.create(MediaType.parse(mimeType), toByteArray(context)))
}

private fun String.toMultipart(formDataName: String): MultipartBody.Part {
    return MultipartBody.Part.createFormData(formDataName, this,
            RequestBody.create(MediaType.parse("text/plain"), toByteArray()))
}

private fun Attachment.toByteArray(context: Context): ByteArray {
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
package com.freelancer.android.sdk.endpoints

import android.content.Context
import com.freelancer.android.sdk.models.Attachment
import com.freelancer.android.sdk.models.MessageThread
import com.freelancer.android.sdk.models.ThreadContext
import com.freelancer.android.sdk.models.ThreadInfo
import com.freelancer.android.sdk.utils.toMultipart
import com.freelancer.android.sdk.utils.toRequestBody
import rx.Observable

/**
 * Created by arranlomas on 21/12/17.
 */
class ThreadsApi internal constructor(
        private val threadsApiRetrofit: ThreadsApiRetrofit,
        private val threadsCreateApiRetrofit: ThreadsCreateApiRetrofit) {

    fun createThread(members: List<Long>,
            contextType: ThreadContext.Type,
            threadContext: Long,
            message: String,
            files: List<Attachment>?,
            type: ThreadInfo.ThreadType,
            androidContext: Context): Observable<MessageThread> {

        return threadsCreateApiRetrofit.createThread(members.toRequestBody(),
                contextType.toRequestBody(),
                threadContext.toRequestBody(),
                message.toRequestBody(),
                files?.toMultipart(androidContext),
                type.toRequestBody())
    }
}
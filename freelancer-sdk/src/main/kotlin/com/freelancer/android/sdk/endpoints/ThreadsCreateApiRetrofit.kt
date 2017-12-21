package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.MessageThread
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import rx.Observable

internal interface ThreadsCreateApiRetrofit {
    @Multipart
    @POST("threads/")
    fun createThread(@Part("members[]") userId: RequestBody,
            @Part("context_type") contextType: RequestBody?,
            @Part("context") context: RequestBody?,
            @Part("message") message: RequestBody?,
            @Part files: List<MultipartBody.Part>?,
            @Part("thread_type") threadType: RequestBody): Observable<MessageThread>
}
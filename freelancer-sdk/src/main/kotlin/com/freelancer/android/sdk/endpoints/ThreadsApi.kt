package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Message
import com.freelancer.android.sdk.models.MessageThread
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.ThreadsResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ThreadsApi {

    @Multipart
    @POST("threads/")
    fun createThread(@Part("members[]") userId: RequestBody,
            @Part("thread_type") threadType: RequestBody,
            @Part("message") message: RequestBody?,
            @Part("context_type") contextType: RequestBody?,
            @Part("contexts[]") context: RequestBody?,
            @Part files: List<MultipartBody.Part>?): Observable<MessageThread>

    @GET("threads/?last_message=true&"
            + "unread_count=true&"
            + "message_count=true&"
            + "thread_events=true&"
            + "user_details=true&"
            + "context_details=true&" +
            "thread_attachments=true")
    fun getThreads(@Query("limit") limit: Int,
            @Query("offset") offset: Int,
            @Query("threads[]") vararg threadIds: Long): Observable<ThreadsResponse>

    /**
     * TODO
     *
     * add endpoint to get thread by id
     * /messages/0.1/threads/{thread_id}
     */

    @FormUrlEncoded
    @PUT("threads/")
    fun update(@Field("threads[]") threadId: Long,
            @Field("action") action: String): Observable<ApiResponse>

    @POST("threads/{thread_id}/typing/")
    fun notifyTyping(@Path("thread_id") threadId: Long): Observable<ApiResponse>

    /**
     * TODO
     *
     * add endpoint to add remove users
     * /messages/0.1/threads/{thread_id}/members
     */

    @Multipart
    @POST("threads/{thread_id}/messages/")
    fun sendMessage(@Path("thread_id") threadId: Long,
            @Part("message") message: RequestBody?,
            @Part("client_message_id") clientId: RequestBody?,
            @Part files: List<MultipartBody.Part>?): Observable<Message>

    @GET("threads/search/?thread_details=true&"
            + "user_details=true&"
            + "context_details=true")
    fun search(@Query("query") query: String): Observable<ThreadsResponse>
}
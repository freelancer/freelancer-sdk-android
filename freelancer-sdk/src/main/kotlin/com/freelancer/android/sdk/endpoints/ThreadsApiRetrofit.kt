package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Message
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

internal interface ThreadsApiRetrofit {

    @GET("threads/")
    fun getThreads(
            @Query("threads[]") threadIds: List<Long>? = null,
            @Query("folders[]") folders: List<Long>? = null,
            @Query("contexts[]") contexts: List<Long>? = null,
            @Part("context_type") contextType: String? = null,
            @Query("members[]") members: List<Long>? = null,
            @Query("owners[]") owners: List<Long>? = null,
            @Query("thread_types[]") threadTypes: List<String>? = null,
            @Query("is_read") is_read: Boolean? = null,
            @Query("is_muted") is_muted: Boolean? = null,
            @Query("from_updated_time") fromUpdatedTime: Long? = null,
            @Query("to_updated_time") toUpdatedTime: Long? = null,
            @Query("count") count: Boolean? = null,
            @Query("message_count") messageCount: Boolean = true,
            @Query("unread_count") unreadCount: Boolean = true,
            @Query("last_message") lastMessage: Boolean = true,
            @Query("unread_thread_count") unreadThreadCount: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("context_details") contextDetails: Boolean = true,
            @Query("thread_attachments") threadAttachments: Boolean = true,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int)
            : Observable<ThreadsResponse>

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
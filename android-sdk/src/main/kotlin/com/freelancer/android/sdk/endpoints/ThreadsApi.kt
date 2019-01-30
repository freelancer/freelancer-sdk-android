package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.MessageThread
import com.freelancer.android.sdk.models.request.ClientMessageIdRequest
import com.freelancer.android.sdk.models.request.ContextTypeRequest
import com.freelancer.android.sdk.models.request.FilesRequest
import com.freelancer.android.sdk.models.request.MembersRequest
import com.freelancer.android.sdk.models.request.MessageRequest
import com.freelancer.android.sdk.models.request.ThreadContextRequest
import com.freelancer.android.sdk.models.request.TypeRequest
import com.freelancer.android.sdk.models.response.ApiResponse
import com.freelancer.android.sdk.models.response.ThreadsResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ThreadsApi {

    @Multipart
    @POST("threads/")
    fun createThread(@Part("members[]") members: MembersRequest?,
                     @Part("context_type") contextType: ContextTypeRequest?,
                     @Part("context") context: ThreadContextRequest?,
                     @Part("message") message: MessageRequest?,
                     @Part files: FilesRequest?,
                     @Part("thread_type") threadType: TypeRequest
    ): Single<MessageThread>

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
            : Single<ThreadsResponse>

    @GET("threads/{thread_id}")
    fun getThreadById(@Path("thread_id") threadId: Long,
                      @Query("message_count") messageCount: Boolean = true,
                      @Query("unread_count") unreadCount: Boolean = true,
                      @Query("last_message") lastMessage: Boolean = true,
                      @Query("user_details") userDetails: Boolean = true,
                      @Query("context_details") contextDetails: Boolean = true,
                      @Query("thread_attachments") threadAttachments: Boolean = true)
            : Single<ThreadsResponse>

    @FormUrlEncoded
    @PUT("threads/")
    fun update(@Field("threads[]") threadId: Long,
               @Field("action") action: String,
               @Query("folders[]") folders: List<Long>? = null,
               @Query("target") target: String? = null,
               @Query("thread_types[]") threadTypes: List<String>? = null,
               @Query("is_read") is_read: Boolean? = null,
               @Query("is_muted") is_muted: Boolean? = null,
               @Query("offset") offset: Int,
               @Query("limit") limit: Int,
               @Query("from_updated_time") fromUpdatedTime: Long? = null,
               @Query("to_updated_time") toUpdatedTime: Long? = null
    ): Single<ApiResponse>

    @POST("threads/{thread_id}/typing/")
    fun notifyTyping(@Path("thread_id") threadId: Long): Single<ApiResponse>

    @FormUrlEncoded
    @PUT("threads/{thread_id}/members")
    fun addOrRemoveUsers(
            @Path("thread_id") threadId: Long,
            @Field("members[]") members: List<Long>? = null,
            @Field("action") action: String? = null): Single<ApiResponse>

    @Multipart
    @POST("threads/{thread_id}/messages/")
    fun createMessage(
            @Path("thread_id") threadId: Long,
            @Part("message") message: MessageRequest?,
            @Part("client_message_id") clientId: ClientMessageIdRequest?,
            @Part files: FilesRequest?
            // TODO -- add attachments (different to files)
            // TODO -- add attachment key
    ): Single<MessageRequest>

    @GET("threads/search/")
    fun search(
            @Query("query") query: String,
            @Query("thread_details") threadDetails: Boolean = true,
            @Query("user_details") userDetails: Boolean = true,
            @Query("context_details") contextDetails: Boolean = true,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int): Single<ThreadsResponse>
}
package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.ThreadsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MessagesApi {

    @GET("messages/")
    fun getMessages(
            @Query("threads[]") threads: List<Long>,
            @Query("senders[]") senders: List<Long>,
            @Query("messages") messages: List<Long>,
            @Query("contexts[]") contexts: List<Long>,
            @Query("context_type") contextType: String,
            @Query("is_read") is_read: Boolean,
            @Query("offset") offset: Long,
            @Query("limit") limit: Long,
            @Query("from_updated_time") fromUpdatedTime: Long,
            @Query("to_updated_time") toUpdatedTime: Long,
            @Query("count") count: Boolean,
            @Query("user_details") userDetails: Boolean,
            @Query("thread_details") threadDetails: Boolean
    ): Observable<ThreadsResponse>

    /**
     * TODO
     *
     * add endpoint to get message by id
     * /messages/0.1/messages/{message_id}
     */

    /**
     * TODO
     *
     * add endpoint to search messages
     * /messages/0.1/messages/search
     */

    /**
     * TODO
     *
     * add endpoint to perform message action
     * /messages/0.1/messages/
     */

}
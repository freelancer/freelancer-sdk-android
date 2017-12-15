package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.ThreadsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface MessagesApi {

    @GET("messages/")
    fun getMessages(@Query("threads[]") threadId: Long,
            @Query("limit") limit: Int,
            @Query("offset") offset: Int): Observable<ThreadsResponse>

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
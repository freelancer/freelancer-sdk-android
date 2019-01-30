package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.DEFAULT_LIMIT_VALUE
import com.freelancer.android.sdk.DEFAULT_OFFSET_VALUE
import com.freelancer.android.sdk.models.Entry
import com.freelancer.android.sdk.models.response.EntriesResponse
import com.freelancer.android.sdk.models.response.EntryResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface EntriesApi {

    @GET("entries?compact")
    fun getEntries(
            @Query("contests[]") contestId: Long,
            @Query("offset") offset: Int = DEFAULT_OFFSET_VALUE,
            @Query("limit") limit: Int = DEFAULT_LIMIT_VALUE,
            @Query("user_details") userDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true): Single<EntriesResponse>

    @GET("entries?compact")
    fun getEntriesWithStatus(
            @Query("contests[]") contestId: List<Long>,
            @Query("statuses[]") statuses: MutableList<Entry.EntryStatus>,
            @Query("user_details") userDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true): Single<EntriesResponse>

    @GET("entries/{entry_id}")
    fun getEntryById(
            @Path("entry_id") entryId: Long,
            @Query("user_details") userDetails: Boolean = true,
            @Query("file_details") fileDetails: Boolean = true,
            @Query("user_avatar") userAvatar: Boolean = true): Single<EntriesResponse>

    @PUT("entries/{entry_id}")
    fun performEntryAction(
            @Path("entry_id") entryId: Long,
            @Query("action") action: String): Single<EntryResponse>

    @PUT("entries/{entry_id}/?action=rate")
    fun rateEntry(
            @Path("entry_id") entryId: Long,
            @Query("rating") rating: Float): Single<EntryResponse>
}
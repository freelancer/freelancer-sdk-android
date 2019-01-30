package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.ApiResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface FilesApi {
    @Multipart
    @PUT("projects/{project_id}/files")
    fun uploadFile(
            @Path("project_id") projectId: Long,
            @Part filedata: MultipartBody.Part
    ): Single<ApiResponse>
}

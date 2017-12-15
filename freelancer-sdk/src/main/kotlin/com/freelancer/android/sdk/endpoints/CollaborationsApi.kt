package com.freelancer.android.sdk.endpoints

interface CollaborationsApi {

    //FIXME - unable to test due to api issues
//    @GET("projects/{project_id}/collaborations/")
//    fun listCollaborations(@Path("project_id") projectId: Long): Observable<CollaborationsListResponse>

    //FIXME - untested due to backend returning 500
//    @POST("projects/{project_id}/collaborations/")
//    fun createAProjectCollaboration(@Path("project_id") projectId: Long,
//            @Body createRequest: CollaborationCreateRequest): Observable<ApiResponse>

    //FIXME - untested due to not being able to create collaborations
//    @POST("/projects/{project_id}/collaborations/{collaboration_id}/")
//    fun projectCollaborationActions(@Path("project_id") projectId: Long,
//            @Path("collaboration_id") collaborationId: Long,
//            @Body actionRequest: CollaborationActionRequest): Observable<ApiResponse>
}
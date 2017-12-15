package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.FLObject
import com.freelancer.android.sdk.models.FLUser
import com.google.gson.annotations.SerializedName

//TODO test this - this response is untested!!
data class CollaborationsListResponse(
        @SerializedName("contexts")
        var contexts: Any? = null,

        @SerializedName("users")
        var users: List<FLUser>? = null,

        @SerializedName("project_collaborations")
        var projectCollaborations: List<ProjectCollaborationResponse>? = null
) : FLObject

data class ProjectCollaborationResponse(
        @SerializedName("type")
        var type: String? = null,

        @SerializedName("id")
        var id: Double? = null
) : FLObject



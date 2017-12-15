package com.freelancer.android.sdk.models.request

data class CollaborationCreateRequest(
        val email: String,
        val username: String,
        val permissions: List<Pair<String, Boolean>>
)
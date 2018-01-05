package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Bid
import com.freelancer.android.sdk.models.Milestone
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.Service

data class ServiceListResponse(
        val services: List<Service>
)

data class ServiceOrderResponse(
        val project: Project,
        val bid: Bid,
        val milestones: List<Milestone>
)

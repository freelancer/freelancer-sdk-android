package com.freelancer.android.sdk.models.response

import com.freelancer.android.sdk.models.Bid
import com.freelancer.android.sdk.models.Milestone
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.Service

data class ServiceListResponse(
        val status: String,
        val result: ServiceListResult
)

data class ServiceListResult(
        val services: List<Service>,
        val users: List<Any>
)

data class ServiceOrderResponse(
        val status: String,
        val result: ServiceOrderResult
)

data class ServiceOrderResult(
        val project: Project,
        val bid: Bid,
        val milestones: List<Milestone>
)

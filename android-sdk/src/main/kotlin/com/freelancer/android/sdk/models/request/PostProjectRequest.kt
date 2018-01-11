package com.freelancer.android.sdk.models.request

import com.freelancer.android.sdk.models.Country
import com.freelancer.android.sdk.models.Currency
import com.freelancer.android.sdk.models.Job
import com.freelancer.android.sdk.models.JobCategory
import com.freelancer.android.sdk.models.Location
import com.freelancer.android.sdk.models.Project
import com.freelancer.android.sdk.models.ProjectBudget
import com.google.gson.annotations.SerializedName

data class PostProjectRequest(
        val title: String,
        val description: String,
        val bidperiod: Int,
        val budget: PostProjectBudgetRequest,
        val currency: PostProjectCurrencyRequest,
        val jobs: List<PostProjectJobRequest> = emptyList(),
        val isContest: Boolean = false,
        val isFavourite: Boolean = false,
        val featured: Boolean = false,
        val local: Boolean = false,
        val urgent: Boolean = false,
        var location: PostProjectLocationRequest? = null,
        var hireme: Boolean = false,
        @SerializedName("hireme_initial_bid")
        var hireMeInitialBid: PostProjectHireMeInitialBid? = null,
        val type: Project.ProjectType? = null,
        @SerializedName("hourly_project_info")
        val hourlyProjectInfo: HourlyProjectInfoRequest? = null
)

data class PostProjectCurrencyRequest(
        val code: String,
        val country: String,
        val exchange_rate: Double,
        val name: String,
        val id: Int,
        val sign: String
)

data class PostProjectBudgetRequest(
        val minimum: Double,
        val maximum: Double
)

data class PostProjectJobRequest(
        val id: Int = 0,
        val name: String,
        val category: PostProjectJobCategoryRequest? = null,
        val active_project_count: Int = 0
)

data class PostProjectJobCategoryRequest(
        var id: Int = 0,
        var name: String? = null
)

data class PostProjectLocationRequest(
        var country: Country? = null,
        var city: String? = null,
        var administrativeArea: String? = null,
        var vicinity: String? = null,
        var latitude: Double = 0.toDouble(),
        var longitude: Double = 0.toDouble(),
        var fullAddress: String? = null
)
data class PostProjectHireMeInitialBid(
        val bidder_id: Int = 0,
        val amount: Float = 0f,
        val period: Int? = null
)

data class HourlyProjectInfoRequest(
        var commitment: HourlyProjectCommitmentRequest,
        @SerializedName("duration_enum")
        var duration: String
)

data class HourlyProjectCommitmentRequest(
        var hours: Int,
        var interval: String
)

fun Project.getAsPostRequest(isContest: Boolean, isFavourite: Boolean, isFeatured: Boolean): PostProjectRequest {
    return PostProjectRequest(
            title = title ?: "",
            description = description ?: "",
            bidperiod = bidPeriod,
            budget = budget?.getAsPostRequest() ?: PostProjectBudgetRequest(10.0, 30.0),
            currency = currency?.getAsPostRequest() ?: PostProjectCurrencyRequest("", "", 1.0, "", 1, ""),
            jobs = jobs?.getAsPostRequest() ?: kotlin.collections.emptyList(),
            isContest = isContest,
            isFavourite = isFavourite,
            featured = isFeatured,
            local = isLocal,
            location = location?.getAsPostRequest()
    )
}

fun ProjectBudget.getAsPostRequest(): PostProjectBudgetRequest {
    return PostProjectBudgetRequest(
            minimum = min,
            maximum = max
    )
}

fun Job.getAsPostRequest(): PostProjectJobRequest {
    return PostProjectJobRequest(
            id = serverId.toInt(),
            name = name ?: "",
            category = category?.getAsPostRequest(),
            active_project_count = activeProjectCount
    )
}

fun Currency.getAsPostRequest(): PostProjectCurrencyRequest {
    return PostProjectCurrencyRequest(
            code = code ?: "",
            country = country ?: "",
            exchange_rate = exchangeRate.toDouble(),
            name = name ?: "",
            id = serverId.toInt(),
            sign = sign ?: ""
    )
}

fun List<Job>.getAsPostRequest(): List<PostProjectJobRequest> {
    val ppoList = mutableListOf<PostProjectJobRequest>()
    forEach { ppoList.add(it.getAsPostRequest()) }
    return ppoList.toList()
}

fun JobCategory.getAsPostRequest(): PostProjectJobCategoryRequest {
    return PostProjectJobCategoryRequest(
            id = serverId.toInt(),
            name = name
    )
}

fun Location.getAsPostRequest(): PostProjectLocationRequest {
    return PostProjectLocationRequest(
            country = country,
            city = city,
            administrativeArea = administrativeArea,
            vicinity = vicinity,
            latitude = latitude,
            longitude = longitude,
            fullAddress = fullAddress
    )
}
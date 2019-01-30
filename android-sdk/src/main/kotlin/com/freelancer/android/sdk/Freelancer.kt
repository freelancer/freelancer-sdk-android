package com.freelancer.android.sdk

import com.freelancer.android.flapi.BuildConfig
import com.freelancer.android.sdk.endpoints.BidsApi
import com.freelancer.android.sdk.endpoints.BudgetsApi
import com.freelancer.android.sdk.endpoints.CategoriesApi
import com.freelancer.android.sdk.endpoints.CollaborationsApi
import com.freelancer.android.sdk.endpoints.ContestApi
import com.freelancer.android.sdk.endpoints.ContestMessagesApi
import com.freelancer.android.sdk.endpoints.CountriesApi
import com.freelancer.android.sdk.endpoints.CurrenciesApi
import com.freelancer.android.sdk.endpoints.EntriesApi
import com.freelancer.android.sdk.endpoints.ExpertGuarunteesApi
import com.freelancer.android.sdk.endpoints.FilesApi
import com.freelancer.android.sdk.endpoints.JobsApi
import com.freelancer.android.sdk.endpoints.MessagesApi
import com.freelancer.android.sdk.endpoints.MilestoneApi
import com.freelancer.android.sdk.endpoints.MilestoneRequestsApi
import com.freelancer.android.sdk.endpoints.ProjectApi
import com.freelancer.android.sdk.endpoints.ReviewsApi
import com.freelancer.android.sdk.endpoints.ServicesApi
import com.freelancer.android.sdk.endpoints.ThreadsApi
import com.freelancer.android.sdk.endpoints.TimezoneApi
import com.freelancer.android.sdk.endpoints.UserApi
import com.freelancer.android.sdk.inteceptors.ApiResponseInterceptor
import com.freelancer.android.sdk.inteceptors.AuthInterceptor
import com.freelancer.android.sdk.inteceptors.UserAgentInteceptor
import com.freelancer.android.sdk.utils.GSON
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Freelancer(private val authToken: String,
        private val userAgent: String,
        private val isDebug: Boolean = false,
        private val isSandbox: Boolean = false,
        private val header: String = "Freelancer-OAuth-V1"
) {
    fun createBidsApi(): BidsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, BidsApi::class.java)
    }

    fun createCategoriesApi(): CategoriesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, CategoriesApi::class.java)
    }

    fun createCollaborationsApi(): CollaborationsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, CollaborationsApi::class.java)
    }

    fun createContestApi(): ContestApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_CONTESTS, ContestApi::class.java)
    }

    fun createContestMessagesApi(): ContestMessagesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_CONTESTS, ContestMessagesApi::class.java)
    }

    fun createCountriesApi(): CountriesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_COMMON, CountriesApi::class.java)
    }

    fun createCurrenciesApi(): CurrenciesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, CurrenciesApi::class.java)
    }

   fun createBudgetsApi(): BudgetsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, BudgetsApi::class.java)
    }

    fun createEntriesApi(): EntriesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_CONTESTS, EntriesApi::class.java)
    }

    fun createExpertGuarunteesApi(): ExpertGuarunteesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_CONTESTS, ExpertGuarunteesApi::class.java)
    }

    fun createFilesApi(): FilesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_CONTESTS, FilesApi::class.java)
    }

    fun createJobsApi(): JobsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, JobsApi::class.java)
    }

    fun createMessagesApi(): MessagesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_MESSAGES, MessagesApi::class.java)
    }

    fun createMilestoneApi(): MilestoneApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, MilestoneApi::class.java)
    }

    fun createMilestoneRequestApi(): MilestoneRequestsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, MilestoneRequestsApi::class.java)
    }

    fun createProjectApi(): ProjectApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, ProjectApi::class.java)
    }

    fun createReviewsApi(): ReviewsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, ReviewsApi::class.java)
    }

    fun createServicesApi(): ServicesApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_PROJECTS, ServicesApi::class.java)
    }

    fun createThreadsApi(): ThreadsApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_MESSAGES, ThreadsApi::class.java)
    }

    fun createTimezoneApi(): TimezoneApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_COMMON, TimezoneApi::class.java)
    }

    fun createUserApi(): UserApi {
        return getRetrofitApi(BuildConfig.API_PREFIX_USERS, UserApi::class.java)
    }

    private fun <T> getRetrofitApi(prefix: String, apiClass: Class<T>): T {

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(AuthInterceptor(header, authToken))
        builder.addInterceptor(UserAgentInteceptor(userAgent))
        builder.addInterceptor(ApiResponseInterceptor())

        if (isDebug) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        val baseUrl = if (isSandbox) BuildConfig.BASE_URL_SANDBOX_API
        else BuildConfig.BASE_URL_API

        val client = builder
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val apiAdapter = Retrofit.Builder()
                .baseUrl(baseUrl + prefix)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return apiAdapter.create(apiClass)
    }
}
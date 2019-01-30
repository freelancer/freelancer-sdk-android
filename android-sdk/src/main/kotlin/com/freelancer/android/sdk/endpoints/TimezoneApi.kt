package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.TimezonesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface TimezoneApi {
    @GET("common/0.1/timezones/")
    fun getTimezones(): Single<TimezonesResponse>
}

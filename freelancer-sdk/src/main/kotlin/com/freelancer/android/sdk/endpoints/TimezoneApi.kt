package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.TimezonesResponse
import retrofit2.http.GET
import rx.Observable

interface TimezoneApi {
    @GET("common/0.1/timezones/")
    fun getTimezones(): Observable<TimezonesResponse>
}

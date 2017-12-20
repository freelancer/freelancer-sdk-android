package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface CurrenciesApi {
    @GET("currencies/")
    fun getCurrencies(@Query("currency_codes[]") currencyCodes: List<String>? = null,
            @Query("currency_ids[]") currencyIds: List<Long>? = null,
            @Query("include_external_currencies") includeExternalCurrencies: Boolean? = null
    ): Observable<CurrencyResponse>
}
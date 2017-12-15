package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.CurrenciesAndBudgetsResponse
import com.freelancer.android.sdk.models.response.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface CurrencyAndBudgetsApi {

    @GET("currencies/")
    fun getCurrency(@Query("currency_ids[]") currencyId: Long): Observable<CurrencyResponse>

    /**
     * Get currency details
     * @return list of currencies
     */
    @GET("budgets/?currency_details")
    fun getCurrenciesAndBudgets(): Observable<CurrenciesAndBudgetsResponse>
}
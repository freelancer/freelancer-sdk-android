package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.CurrenciesAndBudgetsResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by arranlomas on 20/12/17.
 */


interface BudgetsApi {

    @GET("budgets/")
    fun getBudgets(@Query("currency_codes[]") currencyCodes: List<String>? = null,
            @Query("currency_ids[]") currencyIds: List<Long>? = null,
            @Query("project_type") projectType: String? = null,
            @Query("lang") lang: String? = null,
            @Query("currency_details") currencyDetails: Boolean = true
    ): Observable<CurrenciesAndBudgetsResponse>
}
package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.BudgetsResponse
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

internal class BudgetsApiTest : BaseApiTest() {

    private lateinit var budgetsApi: BudgetsApi

    @Before
    fun setUp() {
        budgetsApi = BudgetsApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getCategories() {
        server.enqueue(createMockResponse(readFromFile("get_budgets.json")))

        val subscriber = TestSubscriber<BudgetsResponse>()

        budgetsApi.getBudgets().subscribe(subscriber)
        subscriber.assertCompleted()
        subscriber.awaitTerminalEvent()
        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.onNextEvents.first().let {
            Assert.assertNotNull(it.budgets)
            Assert.assertNotNull(it.currencies)
            Assert.assertEquals(380, it.budgets.size)
            it.budgets.forEach {
                Assert.assertNotNull(it.name)
            }
        }
    }
}
package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.BudgetsResponse
import io.reactivex.observers.TestObserver
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

internal class BudgetsApiTest : BaseApiTest() {

    private lateinit var budgetsApi: BudgetsApi

    @Before
    fun setUp() {
        budgetsApi = BudgetsApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getCategories() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("get_budgets.json")))
        val subscriber = TestObserver<BudgetsResponse>()

        // Act
        budgetsApi.getBudgets().subscribe(subscriber)

        // Assert
        subscriber.assertComplete()
        subscriber.awaitTerminalEvent()
        subscriber.assertComplete()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.values().first().let {
            Assert.assertNotNull(it.budgets)
            Assert.assertNotNull(it.currencies)
            Assert.assertEquals(380, it.budgets.size)
            it.budgets.forEach { budget ->
                Assert.assertNotNull(budget.name)
            }
        }
    }
}
package com.freelancer.android.sdk.endpoints

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

        // Setup test observer
        val testObserver = budgetsApi.getBudgets().test()

        // Assert
        testObserver.awaitTerminalEvent()
        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().first().let {
                    Assert.assertNotNull(it.budgets)
                    Assert.assertNotNull(it.currencies)
                    Assert.assertEquals(380, it.budgets.size)
                    it.budgets.forEach { budget ->
                        Assert.assertNotNull(budget.name)
                    }
                }
    }
}
package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.JobCategory
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Test

internal class CategoriesApiTest : BaseApiTest() {

    private lateinit var categoriesApi: CategoriesApi

    @Before
    fun setUp() {
        categoriesApi = CategoriesApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getCategories() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("get_categories.json")))

        // Setup test observer
        val testObserver = categoriesApi.getCategories().test()

        // Assert
        testObserver.awaitTerminalEvent()
        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().first().let {
                    assertNull(it.jobs)
                    assertEquals(26, it.categories.size)
                    assert(it.categories.contains(JobCategory(1, "Websites, IT & Software")))
                    assert(it.categories.contains(JobCategory(113, "Professional Services")))
                }
    }
}
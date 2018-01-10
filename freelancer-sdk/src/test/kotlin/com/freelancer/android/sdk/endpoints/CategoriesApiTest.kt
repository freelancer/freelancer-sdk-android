package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.JobCategory
import com.freelancer.android.sdk.models.response.JobCategoryResponse
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

internal class CategoriesApiTest : BaseApiTest() {

    private lateinit var categoriesApi: CategoriesApi

    @Before
    fun setUp() {
        categoriesApi = CategoriesApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getCategories() {
        server.enqueue(createMockResponse(readFromFile("get_categories.json")))

        val subscriber = TestSubscriber<JobCategoryResponse>()

        categoriesApi.getCategories().subscribe(subscriber)
        subscriber.assertCompleted()
        subscriber.awaitTerminalEvent()
        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.onNextEvents.first().let {
            assertNull(it.jobs)
            assertEquals(26, it.categories.size)
            assert(it.categories.contains(JobCategory(1, "Websites, IT & Software")))
            assert(it.categories.contains(JobCategory(113, "Professional Services")))
        }
    }

    @Test
    fun fail() {
        assertTrue(false)
    }
}
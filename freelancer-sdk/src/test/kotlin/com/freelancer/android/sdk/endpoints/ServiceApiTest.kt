package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.response.ServiceListResponse
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

internal class ServiceApiTest : BaseApiTest() {

    private lateinit var servicesApi: ServicesApi

    @Before
    fun setUp() {
        servicesApi = ServicesApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getActiveServices() {
        server.enqueue(createMockResponse(readFromFile("get_active_services.json")))

        val subscriber = TestSubscriber<ServiceListResponse>()

        servicesApi.listActiveServices().subscribe(subscriber)

        subscriber.assertCompleted()
        subscriber.awaitTerminalEvent()
        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.onNextEvents.first().let {
            assertTrue(it.services.isNotEmpty())

            assertEquals("Compose a 30-second soundtrack", it.services[0].title)
        }
    }
    
    @Test
    fun getServicesById() {
        server.enqueue(createMockResponse(readFromFile("get_services_by_id.json")))

        val subscriber = TestSubscriber<ServiceListResponse>()

        servicesApi.listServices(services = listOf(56771L, 56772L)).subscribe(subscriber)

        subscriber.assertCompleted()
        subscriber.awaitTerminalEvent()
        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.onNextEvents.first().let {
            assertTrue(it.services.isNotEmpty())

            assertEquals("Create a Caricature", it.services[0].title)
        }
    }
}
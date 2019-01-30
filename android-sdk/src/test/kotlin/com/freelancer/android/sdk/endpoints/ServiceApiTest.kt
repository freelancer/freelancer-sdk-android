package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Service
import com.freelancer.android.sdk.models.response.ServiceListResponse
import com.freelancer.android.sdk.models.response.ServiceOrderResponse
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

internal class ServiceApiTest : BaseApiTest() {

    private lateinit var servicesApi: ServicesApi

    @Before
    fun setUp() {
        servicesApi = ServicesApi::class.java.getRetrofitApi(server)
    }

    @Test
    fun getActiveServices() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("get_active_services.json")))
        val subscriber = TestObserver<ServiceListResponse>()

        // Act
        servicesApi.listActiveServices().subscribe(subscriber)

        // Assert
        subscriber.assertComplete()
        subscriber.awaitTerminalEvent()
        subscriber.assertComplete()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.values().first().let {
            assertTrue(it.services.isNotEmpty())

            assertEquals("Compose a 30-second soundtrack", it.services[0].title)
        }
    }

    @Test
    fun getServicesById() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("get_services_by_id.json")))
        val subscriber = TestObserver<ServiceListResponse>()

        // Act
        servicesApi.listServices(services = listOf(56771L, 56772L)).subscribe(subscriber)

        // Assert
        subscriber.assertComplete()
        subscriber.awaitTerminalEvent()
        subscriber.assertComplete()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.values().first().let {
            assertTrue(it.services.isNotEmpty())

            assertEquals("Create a Caricature", it.services[0].title)
        }
    }


    @Test
    fun orderService() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("order_service.json")))
        val subscriber = TestObserver<ServiceOrderResponse>()

        // Act
        servicesApi.orderService(Service.Type.REGULAR, 56758L).subscribe(subscriber)

        // Assert
        subscriber.assertComplete()
        subscriber.awaitTerminalEvent()
        subscriber.assertComplete()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(1)
        subscriber.values().first().let {
            assertEquals("Remove background from a photo for cwliu", it.project.title)
        }
    }
}
package com.freelancer.android.sdk.endpoints

import com.freelancer.android.sdk.models.Service
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

        // Setup test observer
        val testObserver = servicesApi.listActiveServices().test()

        // Assert
        testObserver.awaitTerminalEvent()
        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().first().let {
                    assertTrue(it.services.isNotEmpty())
                    assertEquals("Compose a 30-second soundtrack", it.services[0].title)
                }
    }

    @Test
    fun getServicesById() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("get_services_by_id.json")))

        // Setup test observer
        val testObserver = servicesApi.listServices(services = listOf(56771L, 56772L)).test()

        // Assert
        testObserver.awaitTerminalEvent()
        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().first().let {
                    assertTrue(it.services.isNotEmpty())
                    assertEquals("Create a Caricature", it.services[0].title)
                }
    }

    @Test
    fun orderService() {
        // Arrange
        server.enqueue(createMockResponse(readFromFile("order_service.json")))

        // Setup test observer
        val testObserver = servicesApi.orderService(Service.Type.REGULAR, 56758L).test()

        // Assert
        testObserver.awaitTerminalEvent()
        testObserver
                .assertComplete()
                .assertNoErrors()
                .assertValueCount(1)
                .values().first().let {
                    assertEquals("Remove background from a photo for cwliu", it.project.title)
                }
    }
}
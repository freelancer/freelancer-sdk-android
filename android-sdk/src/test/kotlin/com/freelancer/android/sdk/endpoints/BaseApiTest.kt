package com.freelancer.android.sdk.endpoints

import android.util.Log
import com.freelancer.android.sdk.inteceptors.ApiResponseInterceptor
import com.freelancer.android.sdk.utils.GSON
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

abstract class BaseApiTest {

    protected val server = MockWebServer()

    @Before
    fun init() {
        server.start()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}

internal fun <T> Class<T>.getRetrofitApi(server: MockWebServer): T {
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.addInterceptor(ApiResponseInterceptor())

    val apiAdapter = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    return apiAdapter.create(this)
}


internal fun Class<*>.getJsonString(path: String): String? {
    var `is`: InputStream? = null
    try {
        `is` = javaClass.classLoader.getResourceAsStream(path)

        val reader = BufferedReader(InputStreamReader(`is`, "UTF-8"))

        val sb = StringBuilder()

        var line = reader.readLine()
        while (line != null) {
            sb.append(line)
            line = reader.readLine()
        }

        `is`.close()

        return sb.toString()
    } catch (ex: IOException) {
        Log.e(javaClass.simpleName, "Error reading json file", ex)
    } finally {
        if (`is` != null) {
            try {
                `is`.close()
            } catch (e: IOException) {
                //QQ
            }
        }
    }

    return null
}

internal fun Any.readFromFile(file: String): String {
    val inputStream = this.javaClass.classLoader.getResourceAsStream(file)
    val result = ByteArrayOutputStream()
    val buffer = ByteArray(1024)
    var length = inputStream.read(buffer)
    while (length != -1) {
        result.write(buffer, 0, length)
        length = inputStream.read(buffer)
    }
    return result.toString("UTF-8")
}

internal fun createMockResponse(body: String): MockResponse {
    return MockResponse().apply {
        setResponseCode(200)
        setBody(body)
        addHeader("Content-type: application/json")
    }
}
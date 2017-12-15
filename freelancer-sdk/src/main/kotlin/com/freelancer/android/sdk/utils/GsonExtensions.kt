package com.freelancer.android.sdk.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.LongSerializationPolicy
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.util.Locale

internal val GSON = GsonBuilder()
        .registerTypeAdapter(Long::class.java, LongTypeAdapter())
        .registerTypeAdapterFactory(LowercaseEnumTypeAdapterFactory())
        .setLongSerializationPolicy(LongSerializationPolicy.STRING)
        .create()

internal class LongTypeAdapter : TypeAdapter<Long?>() {
    override fun write(writer: JsonWriter?, value: Long?) {
        if (value == null) {
            writer?.nullValue()
            return
        }
        writer?.value(value)
    }

    override fun read(reader: JsonReader?): Long? {
        if (reader?.peek() == JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        val stringVal = reader?.nextString()
        return stringVal?.toLongOrNull()
    }
}

/**
 * Attempts to convert enum values by comparing json values to a lower-t
 * case respresentation of the enum value
 */
internal class LowercaseEnumTypeAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val rawType = type.rawType as? Class<T>
        if (rawType?.isEnum != false) {
            return null
        }

        val lowercaseToConstant = HashMap<String, T>()
        for (constant in rawType.enumConstants) {
            lowercaseToConstant.put(toLowercase(constant), constant)
        }

        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T?) {
                if (value == null) {
                    out.nullValue()
                } else {
                    out.value(toLowercase(value))
                }
            }

            @Throws(IOException::class)
            override fun read(reader: JsonReader): T? {
                if (reader.peek() == JsonToken.NULL) {
                    reader.nextNull()
                    return null
                } else {
                    return lowercaseToConstant[reader.nextString().toLowerCase(Locale.US)]
                }
            }
        }
    }

    private fun toLowercase(o: Any?): String = o.toString().toLowerCase(Locale.US)
}

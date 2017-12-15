package com.freelancer.android.sdk.models

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Location(

        @SerializedName("country")
        var country: Country? = null,

        @SerializedName("city")
        var city: String? = null,

        @SerializedName("administrative_area")
        var administrativeArea: String? = null,

        @SerializedName("vicinity")
        var vicinity: String? = null,

        @SerializedName("latitude")
        var latitude: Double = 0.toDouble(),

        @SerializedName("longitude")
        var longitude: Double = 0.toDouble(),

        @SerializedName("full_address")
        var fullAddress: String? = null

) : FLObject {
    val projectCreateJson: JsonObject
        get() {
            val gson = Gson()
            val obj = gson.toJson(this)

            val json = gson.fromJson(obj, JsonObject::class.java)
            return json
        }
}
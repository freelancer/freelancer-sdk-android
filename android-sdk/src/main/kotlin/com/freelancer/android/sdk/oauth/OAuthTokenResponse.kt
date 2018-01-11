package com.freelancer.android.sdk.oauth

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class OAuthTokenResponse(
        @SerializedName("expires_in") val expiresIn: Int,
        @SerializedName("access_token") val accessToken: String,
        @SerializedName("token_type") val tokenType: String,
        @SerializedName("scope") val scope: String,
        @SerializedName("refresh_token") val refresh_token: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(expiresIn)
        parcel.writeString(accessToken)
        parcel.writeString(tokenType)
        parcel.writeString(scope)
        parcel.writeString(refresh_token)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<OAuthTokenResponse> {
        override fun createFromParcel(parcel: Parcel): OAuthTokenResponse = OAuthTokenResponse(parcel)

        override fun newArray(size: Int): Array<OAuthTokenResponse?> = arrayOfNulls(size)
    }
}

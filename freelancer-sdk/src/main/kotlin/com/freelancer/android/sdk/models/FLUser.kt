package com.freelancer.android.sdk.models

import com.google.gson.annotations.SerializedName

data class FLUser(

        @SerializedName("id")
        var serverId: Long = 0,

        @SerializedName("username")
        var userName: String? = null,

        @SerializedName(value = "avatar", alternate = arrayOf("profile_logo_url"))
        var avatar: String? = null,

        @SerializedName(value = "avatar_large", alternate = arrayOf("logo_url"))
        var avatarLarge: String? = null,

        @SerializedName("suspended")
        var isSuspended: Boolean = false,

        @SerializedName("is_active")
        var isActive: Boolean = false,

        @SerializedName("force_verify")
        var isForceVerify: Boolean = false,

        @SerializedName("closed")
        var isClosed: Boolean = false,

        @SerializedName("reputation")
        var reputationAsFreelancer: Reputation? = null,

        @SerializedName("employer_reputation")
        var reputationAsEmployer: Reputation? = null,

        @SerializedName("location")
        var location: Location? = null,

        @SerializedName("profile_description")
        var profileDescription: String? = null,

        @SerializedName("tagline")
        var tagline: String? = null,

        @SerializedName("display_name")
        var displayName: String? = null,

        @SerializedName("email")
        var email: String? = null,

        @SerializedName("chosen_role")
        var role: Role? = null,

        @SerializedName("status")
        var userStatus: UserStatus? = null,

        @SerializedName("jobs")
        var jobs: List<Job>? = null,

        @SerializedName("account_balances")
        var accountBalances: AccountBalances? = null,

        @SerializedName("cover_image")
        var coverImage: CoverImage? = null,

        @SerializedName("qualifications")
        var qualifications: List<Qualification>? = null,

        @SerializedName("hourly_rate")
        var hourlyRate: Double = 0.toDouble(),

        @SerializedName("primary_currency")
        var primaryCurrency: Currency? = null,

        @SerializedName("membership_package")
        var membershipPackage: UserMembershipPackage? = null,

        @SerializedName("timezone")
        var timezone: Timezone? = null
) : FLObject {

    val name: String?
        get() {
            return if (!displayName.isNullOrEmpty()) {
                displayName
            } else {
                userName
            }
        }

    val image: String?
        get() {
            return if (!avatarLarge.isNullOrEmpty()) {
                avatarLarge
            } else {
                avatar
            }
        }

    enum class Role {
        FREELANCER, EMPLOYER;

        override fun toString(): String = name.toLowerCase()
    }

    object OnlineOfflineStatus {
        const val UNKNOWN = -1
        const val OFFLINE = 1
        const val ONLINE = 2
    }
}
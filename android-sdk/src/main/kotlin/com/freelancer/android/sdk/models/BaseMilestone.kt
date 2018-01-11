package com.freelancer.android.sdk.models

interface BaseMilestone : FLObject {

    fun getMilestoneBidderId() : Long

    fun getMilestoneTime(): Long

    fun getMilestoneDescription(): String?

    fun getMilestoneCurrency(): Currency?

    fun getMilestoneAmount(): Double

    fun isReleased(): Boolean

}
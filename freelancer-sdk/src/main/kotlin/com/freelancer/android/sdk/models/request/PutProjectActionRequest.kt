package com.freelancer.android.sdk.models.request

class PutProjectActionRequest (projectAction: PutProjectAction) {
    val action: String

    init {
        action = projectAction.toString().toLowerCase()
    }
}

enum class PutProjectAction(internal val action: String) {
    SIGN_NDA("sign_nda"),
    UPGRADE("upgrade"),
    SET_LOCATION("set_location"),
    CLOSE("close"),
    ADD_ATTACHMENT("add_attachment");
}
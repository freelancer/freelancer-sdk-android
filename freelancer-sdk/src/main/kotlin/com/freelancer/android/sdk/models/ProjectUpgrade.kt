package com.freelancer.android.sdk.models

import java.util.Locale

enum class ProjectUpgrade{
    NDA,
    ASSISTED,
    URGENT,
    FEATURED,
    NONPUBLIC,
    FULLTIME,
    QUALIFIED,
    SEALED;

    override fun toString(): String = name.toLowerCase(Locale.US)
}
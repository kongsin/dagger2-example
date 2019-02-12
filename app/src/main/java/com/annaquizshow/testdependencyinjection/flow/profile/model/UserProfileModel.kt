package com.annaquizshow.testdependencyinjection.flow.profile.model

import com.squareup.moshi.Json

data class UserProfileModel(
    @Json(name = "id") val id: Long,
    @Json(name = "displayName") val displayName:  String,
    @Json(name = "coverImageUrl") val coverImageUrl: String
)
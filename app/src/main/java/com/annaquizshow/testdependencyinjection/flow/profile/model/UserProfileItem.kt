package com.annaquizshow.testdependencyinjection.flow.profile.model

import com.squareup.moshi.Json

data class UserProfileItem(
    @Json(name = "items")var items: List<UserProfileModel>
)
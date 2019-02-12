package com.annaquizshow.testdependencyinjection.network.models

import com.squareup.moshi.Json

abstract class BaseModel<T>(
    @Json(name = "data") var data: T? = null
)
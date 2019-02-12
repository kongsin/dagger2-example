package com.annaquizshow.testdependencyinjection.network.interfaces

import com.annaquizshow.testdependencyinjection.flow.profile.model.CoreProfileInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface UserApiInterface {

    @GET("/kongsin/dagger2-example/master/db.json")
    fun getUserInfo() : Deferred<Response<CoreProfileInfo>>

}
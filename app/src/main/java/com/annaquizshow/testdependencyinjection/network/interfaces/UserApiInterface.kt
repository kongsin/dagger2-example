package com.annaquizshow.testdependencyinjection.network.interfaces

import com.annaquizshow.testdependencyinjection.flow.profile.model.CoreProfileInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiInterface {

    @GET("/users/top-rank/follower")
    fun getUserInfo(@Query("start") start: Int = 0, @Query("length") length: Int = 10) : Deferred<Response<CoreProfileInfo>>

}
package com.annaquizshow.testdependencyinjection.flow.profile.repo

import com.annaquizshow.testdependencyinjection.BaseRepo
import com.annaquizshow.testdependencyinjection.flow.profile.model.CoreProfileInfo
import com.annaquizshow.testdependencyinjection.network.interfaces.UserApiInterface
import kotlinx.coroutines.Deferred
import retrofit2.Response

class UserProfileRepo(var userProfileApi : UserApiInterface) : BaseRepo() {

    fun getUserInfo() : Deferred<Response<CoreProfileInfo>> {
        return userProfileApi.getUserInfo()
    }

}
package com.annaquizshow.testdependencyinjection.flow.profile.usecase

import androidx.lifecycle.MutableLiveData
import com.annaquizshow.testdependencyinjection.BaseUseCase
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel
import com.annaquizshow.testdependencyinjection.flow.profile.repo.UserProfileRepo
import com.annaquizshow.testdependencyinjection.network.models.ResponseWraper

class ProfileUseCase(var profileRepo: UserProfileRepo) : BaseUseCase() {

    private val profileData by lazy { MutableLiveData<List<UserProfileModel>>() }
    private val profileByNameData by lazy { MutableLiveData<List<UserProfileModel>>() }

    fun getProfile() : MutableLiveData<List<UserProfileModel>> {
        loadProfile { res ->
            when(res) {
                is ResponseWraper.Success -> {
                    profileByNameData.value = res.info
                }
            }
        }
        return profileData
    }

    fun getMemberNameStartWith(firstChar: String) : MutableLiveData<List<UserProfileModel>>  {
        loadProfile{ res ->
            when(res) {
                is ResponseWraper.Success -> {
                    res.info.filter { it.displayName.toLowerCase().startsWith(firstChar) }.also {
                        profileByNameData.value = it
                    }
                }
            }
        }
        return profileByNameData
    }

    private fun loadProfile(responseWraper: (ResponseWraper<List<UserProfileModel>>) -> Unit) {
        result {
            main {
                val result = call { profileRepo.getUserInfo() }.await()
                when {
                    result.isSuccessful -> {
                        responseWraper.invoke(ResponseWraper.Success(result.body()?.data?.items ?: emptyList()))
                    }
                    else -> {
                        responseWraper.invoke(ResponseWraper.Error(result.errorBody()?.string() ?: "Unknown error"))
                    }
                }
            }
            ResponseWraper.Success(true)
        }
    }

}
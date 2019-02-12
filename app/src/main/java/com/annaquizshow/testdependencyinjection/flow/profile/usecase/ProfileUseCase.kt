package com.annaquizshow.testdependencyinjection.flow.profile.usecase

import androidx.lifecycle.MutableLiveData
import com.annaquizshow.testdependencyinjection.BaseUseCase
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel
import com.annaquizshow.testdependencyinjection.flow.profile.repo.UserProfileRepo

class ProfileUseCase(var profileRepo: UserProfileRepo) : BaseUseCase() {

    fun getProfile() : MutableLiveData<List<UserProfileModel>> {
        return object : MutableLiveData<List<UserProfileModel>>() {
            override fun onActive() {
                super.onActive()
                deferreds.add(io {
                    val res = profileRepo.getUserInfo().await()
                    when {
                        res.isSuccessful -> {
                            postValue(res.body()?.data?.items ?: emptyList())
                        }
                        else -> {
                            res.errorBody()?.string() ?: "Unknown error"
                        }
                    }
                })
            }
        }
    }

    fun getMemberNameStartWith(firstChar: String) : MutableLiveData<List<UserProfileModel>>  {
        return object : MutableLiveData<List<UserProfileModel>>() {
            override fun onActive() {
                super.onActive()
                deferreds.add(io {
                    val result = profileRepo.getUserInfo().await()
                    when {
                        result.isSuccessful -> {
                            postValue(result.body()?.data?.items?.filter {
                                it.displayName.toLowerCase().startsWith(firstChar)
                            } ?: emptyList())
                        }
                        else -> {
                            result.errorBody()?.string() ?: "Unknown error"
                        }
                    }
                })
            }
        }
    }

}
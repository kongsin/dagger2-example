package com.annaquizshow.testdependencyinjection.flow.profile.usecase

import androidx.lifecycle.MutableLiveData
import com.annaquizshow.testdependencyinjection.BaseUseCase
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel
import com.annaquizshow.testdependencyinjection.flow.profile.repo.UserProfileRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileUseCase(var profileRepo: UserProfileRepo) : BaseUseCase() {

    fun getProfile(error: (String) -> Unit = {}) : MutableLiveData<List<UserProfileModel>> {
        return object : MutableLiveData<List<UserProfileModel>>() {
            override fun onActive() {
                super.onActive()
                io {
                    val res = profileRepo.getUserInfo().also {
                        deferreds.add(it)
                    }.await()
                    when {
                        res.isSuccessful -> {
                            main {
                                postValue(res.body()?.data?.items ?: emptyList())
                            }
                        }
                        else -> {
                            main {
                                error.invoke(res.errorBody()?.string() ?: "")
                            }
                        }
                    }
                }
            }
        }
    }

    fun getMemberNameStartWith(firstChar: String, error: (String) -> Unit = {}) : MutableLiveData<List<UserProfileModel>>  {
        return object : MutableLiveData<List<UserProfileModel>>() {
            override fun onActive() {
                super.onActive()
                io {
                    val result = profileRepo.getUserInfo().also {
                        deferreds.add(it)
                    }.await()
                    when {
                        result.isSuccessful -> {
                            main {
                                postValue(result.body()?.data?.items?.filter {
                                    it.displayName.toLowerCase().startsWith(firstChar)
                                } ?: emptyList())
                            }
                        }
                        else -> {
                            main {
                                error.invoke(result.errorBody()?.string() ?: "Unknown error")
                            }
                        }
                    }
                }
            }
        }
    }

}
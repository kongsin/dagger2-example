package com.annaquizshow.testdependencyinjection.flow.profile.viewmodel

import androidx.lifecycle.MutableLiveData
import com.annaquizshow.testdependencyinjection.BaseViewModelAbstract
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel
import com.annaquizshow.testdependencyinjection.flow.profile.usecase.ProfileUseCase
import com.annaquizshow.testdependencyinjection.flow.profile.view.UserProfileInterface

class UserProfileViewModel(var userProfileUserCase: ProfileUseCase) : BaseViewModelAbstract<UserProfileInterface>() {

    fun getUserProfile() : MutableLiveData<List<UserProfileModel>> {
        return userProfileUserCase.getProfile { error ->
            view.onLoadProfileError(error)
        }
    }

    fun getMemberNameStartWith(char: String) : MutableLiveData<List<UserProfileModel>> {
        return userProfileUserCase.getMemberNameStartWith(char) { error ->
            view.onLoadProfileError(error)
        }
    }

    override fun stop() {
        userProfileUserCase.clear()
    }

}
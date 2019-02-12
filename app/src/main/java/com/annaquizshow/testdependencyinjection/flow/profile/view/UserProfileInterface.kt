package com.annaquizshow.testdependencyinjection.flow.profile.view

import com.annaquizshow.testdependencyinjection.BaseView
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel

interface UserProfileInterface : BaseView {

    fun onLoadProfileSuccess(model: List<UserProfileModel>)
    fun onShowLoading()
    fun onDismissLoading()
    fun onLoadProfileError(message: String)

}
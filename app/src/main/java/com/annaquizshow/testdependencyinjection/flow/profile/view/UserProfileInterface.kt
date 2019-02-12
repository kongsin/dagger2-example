package com.annaquizshow.testdependencyinjection.flow.profile.view

import com.annaquizshow.testdependencyinjection.BaseView
import com.annaquizshow.testdependencyinjection.flow.profile.model.UserProfileModel

interface UserProfileInterface : BaseView {

    fun onLoadProfileFinish(model : List<UserProfileModel>)
    fun onLoadProfileError(message: String)
    fun onShowLoading()
    fun onDismissLoading()

}
package com.annaquizshow.testdependencyinjection

import androidx.lifecycle.ViewModel

abstract class BaseViewModelAbstract<T : BaseView> : ViewModel(), BaseViewModelInterface<T> {

    lateinit var view: T

    override fun injectView(view: T) {
        this.view = view
    }

}
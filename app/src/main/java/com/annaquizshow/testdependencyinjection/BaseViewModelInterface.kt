package com.annaquizshow.testdependencyinjection

interface BaseViewModelInterface<T : BaseView> {

    fun injectView(view: T)
    fun stop()

}
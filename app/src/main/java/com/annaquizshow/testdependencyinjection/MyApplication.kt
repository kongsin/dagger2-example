package com.annaquizshow.testdependencyinjection

import android.app.Activity
import com.annaquizshow.testdependencyinjection.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}

inline fun <reified T> Activity.argument(key: String) : T? {
    return this.intent.extras?.get(key) as T
}

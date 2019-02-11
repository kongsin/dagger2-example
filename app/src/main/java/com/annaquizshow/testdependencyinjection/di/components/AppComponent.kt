package com.annaquizshow.testdependencyinjection.di.components

import com.annaquizshow.testdependencyinjection.MyApplication
import com.annaquizshow.testdependencyinjection.di.modules.ActivityModule
import com.annaquizshow.testdependencyinjection.di.modules.AppModule
import com.annaquizshow.testdependencyinjection.di.modules.FragmentModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    FragmentModule::class
])

interface AppComponent : AndroidInjector<MyApplication>{

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()

}
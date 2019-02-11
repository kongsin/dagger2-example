package com.annaquizshow.testdependencyinjection.di.modules

import com.annaquizshow.testdependencyinjection.MainActivity
import com.annaquizshow.testdependencyinjection.ProfileActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeProfileActivity() : ProfileActivity

}
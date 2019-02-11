package com.annaquizshow.testdependencyinjection.di.modules

import com.annaquizshow.testdependencyinjection.ProfileSettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract fun contributesProfileSettingFragment() : ProfileSettingFragment

}
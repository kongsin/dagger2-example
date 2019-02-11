package com.annaquizshow.testdependencyinjection.di.modules

import android.preference.PreferenceManager
import com.annaquizshow.testdependencyinjection.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideSharedPreference(context: MyApplication) = PreferenceManager.getDefaultSharedPreferences(context)

}
package com.annaquizshow.testdependencyinjection.di.modules

import com.annaquizshow.testdependencyinjection.MyApplication
import com.annaquizshow.testdependencyinjection.UserProfileManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideUserManager(context: MyApplication) : UserProfileManager = UserProfileManager(context)

}
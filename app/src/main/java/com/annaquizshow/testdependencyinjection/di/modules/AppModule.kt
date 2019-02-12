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

    @Provides
    fun provideList() = Foo().apply {
        this.lists = listOf(getSource(1), getSource(2), getSource(3))
    }

    @Provides
    fun provideListNumber() = listOf("1", "2", "3")

    @Provides
    fun getSource(v : Int) : Source<String> {
        return object : Source<String> {

            override fun nextT() = "Hello $v"

        }
    }

}


interface Source<T> {
    fun nextT(): T
}

class Foo {

    lateinit var lists : List<Source<String>>
}
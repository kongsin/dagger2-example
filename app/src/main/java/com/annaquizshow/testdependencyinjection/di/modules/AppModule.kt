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
    fun provideList() : Foo {
        return Foo().apply {
            this.lists = listOf(getSource(1),getSource(2),getSource(3))
        }
    }

}

//Just example for real should move below code to separated class.
fun getSource(v : Int) : Source<String> {
    return object : Source<String> {

        override fun nextT() = "Hello $v"

    }
}

interface Source<out T> {
    fun nextT(): T
}

class Foo {

    lateinit var lists : List<Source<String>>
}
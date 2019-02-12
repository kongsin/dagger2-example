package com.annaquizshow.testdependencyinjection.di.modules

import android.util.Log
import com.annaquizshow.testdependencyinjection.network.interfaces.UserApiInterface
import com.annaquizshow.testdependencyinjection.network.models.BaseUrlModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun proveidesOkhttp() : OkHttpClient {
        return OkHttpClient
            .Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    @Inject
    fun providesRetrofit(baseUrl: BaseUrlModel) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl.baseUrlDev)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideBaseUrl() = BaseUrlModel(baseUrlDev = "", baseUrlProd = "")

    @Singleton
    @Provides
    fun providesUserApi(retrofit: Retrofit) : UserApiInterface {
        return retrofit.create(UserApiInterface::class.java)
    }

}
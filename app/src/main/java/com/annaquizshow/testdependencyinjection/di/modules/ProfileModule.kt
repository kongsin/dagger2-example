package com.annaquizshow.testdependencyinjection.di.modules

import com.annaquizshow.testdependencyinjection.flow.profile.repo.UserProfileRepo
import com.annaquizshow.testdependencyinjection.flow.profile.usecase.ProfileUseCase
import com.annaquizshow.testdependencyinjection.flow.profile.viewmodel.UserProfileViewModel
import com.annaquizshow.testdependencyinjection.network.interfaces.UserDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ProfileModule {

    @Inject
    @Provides
    fun providesUserProfileViewModel(userProfileRepo: ProfileUseCase) = UserProfileViewModel(userProfileRepo)

    @Inject
    @Provides
    fun providesUserProfileRepo(userApi: UserDataSource) = UserProfileRepo(userApi)

    @Inject
    @Provides
    fun providesProfileUseCase(repo: UserProfileRepo) = ProfileUseCase(repo)

}
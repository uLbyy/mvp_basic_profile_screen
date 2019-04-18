package com.haslan.profilescreen.di.module

import com.haslan.profilescreen.presentation.ProfileScreenPresenter
import com.haslan.profilescreen.presentation.implementation.ProfileScreenPresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class PresentationModule {

    @Binds
    abstract fun profileScreenPresenter(loginPresenter: ProfileScreenPresenterImpl): ProfileScreenPresenter
}
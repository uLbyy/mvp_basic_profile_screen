package com.haslan.profilescreen.di

import com.haslan.profilescreen.di.module.PresentationModule
import com.haslan.profilescreen.presentation.ProfileScreenPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun profileScreenPresenter(): ProfileScreenPresenter
}
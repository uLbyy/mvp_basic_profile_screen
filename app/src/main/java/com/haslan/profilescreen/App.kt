package com.haslan.profilescreen

import android.app.Application
import com.haslan.profilescreen.di.AppComponent
import com.haslan.profilescreen.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
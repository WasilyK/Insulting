package com.wasilyk.app.insulting.app

import android.app.Application
import com.wasilyk.app.insulting.di.components.AppComponent
import com.wasilyk.app.insulting.di.components.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}
package com.wasilyk.app.insulting.app

import com.github.terrakok.cicerone.Cicerone
import com.wasilyk.app.insulting.di.components.DaggerAppComponent
import com.wasilyk.app.insulting.mvp.views.screens.ScreensImpl
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> {
        val cicerone = Cicerone.create()

        return DaggerAppComponent
            .factory()
            .create(
                applicationContext,
                cicerone.router,
                cicerone.getNavigatorHolder(),
                ScreensImpl()
            )
    }

}
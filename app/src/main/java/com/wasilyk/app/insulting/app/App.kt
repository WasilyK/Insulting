package com.wasilyk.app.insulting.app

import com.github.terrakok.cicerone.Cicerone
import com.wasilyk.app.insulting.di.components.DaggerAppComponent
import com.wasilyk.app.insulting.mvp.views.screens.ScreensImpl
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .withScreens(ScreensImpl())
            .build()
}
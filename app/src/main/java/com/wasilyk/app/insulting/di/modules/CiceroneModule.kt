package com.wasilyk.app.insulting.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.mvp.views.screens.ScreensImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {
    private val cicerone = Cicerone.create()

    @Singleton
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun provideRouter(): Router = cicerone.router

    @Provides
    fun provideScreens(): Screens = ScreensImpl()
}
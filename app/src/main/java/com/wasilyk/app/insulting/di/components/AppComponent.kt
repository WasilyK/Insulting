package com.wasilyk.app.insulting.di.components

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.app.App
import com.wasilyk.app.insulting.di.modules.AppModule
import com.wasilyk.app.insulting.di.modules.RepoModule
import com.wasilyk.app.insulting.di.modules.RetrofitModule
import com.wasilyk.app.insulting.di.modules.RoomModule
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    RepoModule::class,
    RetrofitModule::class,
    RoomModule::class]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance router: Router,
            @BindsInstance navigatorHolder: NavigatorHolder,
            @BindsInstance screens: Screens
        ): AppComponent
    }
}
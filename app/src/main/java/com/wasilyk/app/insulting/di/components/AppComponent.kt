package com.wasilyk.app.insulting.di.components

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.wasilyk.app.insulting.di.modules.CiceroneModule
import com.wasilyk.app.insulting.di.modules.RepoModule
import com.wasilyk.app.insulting.di.modules.RetrofitModule
import com.wasilyk.app.insulting.di.modules.RoomModule
import com.wasilyk.app.insulting.mvp.presenters.InsultGenPresenter
import com.wasilyk.app.insulting.mvp.presenters.InsultsListPresenter
import com.wasilyk.app.insulting.mvp.views.InsultGenFragment
import com.wasilyk.app.insulting.mvp.views.InsultsListFragment
import com.wasilyk.app.insulting.mvp.views.MainActivity
import com.wasilyk.app.insulting.mvp.views.screens.Screens
import com.wasilyk.app.insulting.repository.local.LocalDataSource
import com.wasilyk.app.insulting.repository.local.room.InsultsDao
import com.wasilyk.app.insulting.repository.remote.retrofit.InsultApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CiceroneModule::class,
    RepoModule::class,
    RetrofitModule::class,
    RoomModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    /* Cicerone */
    fun getNavigatorHolder(): NavigatorHolder
    fun getRouter(): Router
    fun getScreens(): Screens

    /* injects */
    fun inject(mainActivity: MainActivity)

    /* Presenters */
    fun getInsultsListPresenter(): InsultsListPresenter
    fun getInsultGenPresenter(): InsultGenPresenter

    /* RepoModule */
    fun getLocalDataSource(): LocalDataSource

    /* RoomModule */
    fun getInsultsDao(): InsultsDao

    /* RetrofitModule */
    fun getInsultApi(): InsultApi
}
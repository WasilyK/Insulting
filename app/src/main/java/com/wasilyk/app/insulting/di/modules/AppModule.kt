package com.wasilyk.app.insulting.di.modules

import com.wasilyk.app.insulting.mvp.views.InsultGenFragment
import com.wasilyk.app.insulting.mvp.views.InsultsListFragment
import com.wasilyk.app.insulting.mvp.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindInsultGenFragment(): InsultGenFragment

    @ContributesAndroidInjector
    fun bindInsultsListFragment(): InsultsListFragment
}
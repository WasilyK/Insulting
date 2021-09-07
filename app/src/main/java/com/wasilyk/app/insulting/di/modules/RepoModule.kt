package com.wasilyk.app.insulting.di.modules

import com.wasilyk.app.insulting.repository.local.LocalDataSource
import com.wasilyk.app.insulting.repository.local.LocalDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideLocalDataSource(): LocalDataSource = LocalDataSourceImpl()
}
package com.wasilyk.app.insulting.di.modules

import com.wasilyk.app.insulting.repository.local.LocalDataSource
import com.wasilyk.app.insulting.repository.local.LocalDataSourceImpl
import com.wasilyk.app.insulting.repository.remote.RemoteDataSource
import com.wasilyk.app.insulting.repository.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    fun bindLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource
}
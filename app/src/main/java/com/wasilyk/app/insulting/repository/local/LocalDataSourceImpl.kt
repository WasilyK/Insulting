package com.wasilyk.app.insulting.repository.local

import com.wasilyk.app.insulting.app.App
import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Single

class LocalDataSourceImpl : LocalDataSource {

    private val insultsDao = App.instance.appComponent.getInsultsDao()

    override fun getData(): Single<List<Insult>> =
        insultsDao.selectAll()
}
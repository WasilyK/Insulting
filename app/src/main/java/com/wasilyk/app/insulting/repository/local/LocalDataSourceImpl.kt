package com.wasilyk.app.insulting.repository.local

import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.repository.local.room.InsultsDao
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val insultsDao: InsultsDao
) : LocalDataSource {

    override fun getData(): Single<List<Insult>> =
        insultsDao.selectAll()
}
package com.wasilyk.app.insulting.repository.local

import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {
    fun getData(): Single<List<Insult>>
}
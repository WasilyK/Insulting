package com.wasilyk.app.insulting.repository.remote

import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Single

interface RemoteDataSource {
    fun getData(): Single<Insult>
}
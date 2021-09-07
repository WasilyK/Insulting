package com.wasilyk.app.insulting.repository.remote

import com.wasilyk.app.insulting.app.App
import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {
    override fun getData(): Single<Insult> =
        App.instance.appComponent.getInsultApi().getInsult()
}

package com.wasilyk.app.insulting.repository.remote

import com.wasilyk.app.insulting.mvp.models.Insult
import com.wasilyk.app.insulting.repository.remote.retrofit.InsultApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val insultApi: InsultApi
) : RemoteDataSource {

    override fun getData(): Single<Insult> =
        insultApi.getInsult()
}

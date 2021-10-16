package com.wasilyk.app.insulting.repository.remote.retrofit

import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface InsultApi {
    @GET("generate_insult.php?lang=en&type=json")
    fun getInsult(): Single<Insult>
}
package com.wasilyk.app.insulting.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wasilyk.app.insulting.di.annotations.Url
import com.wasilyk.app.insulting.repository.remote.retrofit.InsultApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @Url
    fun provideUrl(): String = "https://evilinsult.com/"

    @Provides
    @Reusable
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Reusable
    fun provideInsultApi(@Url url: String, gson: Gson): InsultApi = Retrofit.Builder()
        .baseUrl(url)
        .client(OkHttpClient.Builder().build())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(InsultApi::class.java)
}
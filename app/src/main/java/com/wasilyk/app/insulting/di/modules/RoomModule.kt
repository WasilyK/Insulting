package com.wasilyk.app.insulting.di.modules

import android.content.Context
import androidx.room.Room
import com.wasilyk.app.insulting.repository.local.room.InsultsDao
import com.wasilyk.app.insulting.repository.local.room.InsultsDataBase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class RoomModule {
    private val dbName = "insults.db"

    @Singleton
    @Provides
    fun provideDatabase(context: Context): InsultsDataBase =
        Room.databaseBuilder(context, InsultsDataBase::class.java, dbName).build()

    @Reusable
    @Provides
    fun provideInsultsDao(db: InsultsDataBase): InsultsDao = db.getInsultsDao()
}
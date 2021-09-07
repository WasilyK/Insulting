package com.wasilyk.app.insulting.repository.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wasilyk.app.insulting.mvp.models.Insult

@Database(entities = [Insult::class], version = 1, exportSchema = false)
abstract class InsultsDataBase : RoomDatabase() {
    abstract fun getInsultsDao(): InsultsDao
}
package com.wasilyk.app.insulting.repository.local.room

import androidx.room.*
import com.wasilyk.app.insulting.mvp.models.Insult
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface InsultsDao {

    @Query("SELECT * FROM insults_tb ORDER BY created")
    fun selectAll(): Single<List<Insult>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(insult: Insult): Completable
}
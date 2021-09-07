package com.wasilyk.app.insulting.mvp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "insults_tb")
data class Insult(
    @PrimaryKey
    @ColumnInfo(name = "number")
    @SerializedName("number")
    val number: Int,

    @ColumnInfo(name = "text")
    @SerializedName("insult")
    val text: String,

    @ColumnInfo(name = "created")
    @SerializedName("created")
    val created: String,

    @ColumnInfo(name = "shown")
    @SerializedName("shown")
    val shown: Int
)

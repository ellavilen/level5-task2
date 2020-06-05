package com.example.level5_task2

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "GameDB")
data class Game(
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var platform: String,
    @ColumnInfo(name = "releaseDate")
    var release: Date,
    @PrimaryKey var id: Long? = null
) : Parcelable
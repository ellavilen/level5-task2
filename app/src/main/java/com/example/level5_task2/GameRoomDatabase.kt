package com.example.level5_task2

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(entities = [Game::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)

abstract class GameRoomDatabase : RoomDatabase() {
    abstract fun gameDao() : GameDAO

    companion object{
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var INSTANCE: GameRoomDatabase? = null

        fun getDatabase(context: Context) : GameRoomDatabase?{
            if(INSTANCE == null){
                synchronized(GameRoomDatabase::class.java){
                    if(INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            GameRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                        }
                    }
                }
            return INSTANCE
            }
        }
    }
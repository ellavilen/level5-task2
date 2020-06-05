package com.example.level5_task2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameDAO {
    @Insert
    suspend fun insertGame(game : Game)

    @Query("SELECT * FROM GameDB ORDER BY releaseDate")
    fun getGameLog(): LiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game : Game)

    @Query("DELETE FROM GameDB")
    suspend fun deleteAllGames()

}
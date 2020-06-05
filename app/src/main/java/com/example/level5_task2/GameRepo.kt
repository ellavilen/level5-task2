package com.example.level5_task2

import android.content.Context
import androidx.lifecycle.LiveData

class GameRepo(context: Context) {
    private val gameDao: GameDAO

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGameLog() : LiveData<List<Game>> {
        return gameDao.getGameLog()
    }

    suspend fun insertGame(game: Game) {
        return gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        return gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        return gameDao.deleteAllGames()
    }
}
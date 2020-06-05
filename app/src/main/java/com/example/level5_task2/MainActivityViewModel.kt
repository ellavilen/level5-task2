package com.example.level5_task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val gameRepo = GameRepo(application.applicationContext)
    private val ioScope = CoroutineScope(Dispatchers.IO)

    val games: LiveData<List<Game>> = gameRepo.getGameLog()

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepo.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        ioScope.launch {
            gameRepo.deleteGame(game)
        }
    }

    fun deleteAllGames() {
        ioScope.launch {
            gameRepo.deleteAllGames()
        }
    }
}
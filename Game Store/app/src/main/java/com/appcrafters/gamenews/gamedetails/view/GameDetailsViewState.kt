package com.appcrafters.gamenews.gamedetails.view

import com.example.games.model.GameDetails

sealed class GameDetailsViewState {
    object Proccessing: GameDetailsViewState()
    data class DataReceived(val game: GameDetails) : GameDetailsViewState()
    data class ErrorReceived(val message: String) : GameDetailsViewState()
}
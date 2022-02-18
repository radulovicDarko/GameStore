package com.appcrafters.gamenews.gamelist.view

import com.example.games.model.Game

sealed class GameListViewState {

    object Proccessing : GameListViewState()
    data class DataReceived(val games: List<Game>) : GameListViewState()
    data class ErrorReceived(val message: String) : GameListViewState()
}
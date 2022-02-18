package com.appcrafters.gamenews.gamelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appcrafters.gamenews.base.data.GamesDataSource
import com.appcrafters.gamenews.base.functional.Either
import com.appcrafters.gamenews.gamelist.view.GameListViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameListViewModel(private val dataSource: GamesDataSource) : ViewModel() {

    private val _state = MutableLiveData<GameListViewState>()
    val state: LiveData<GameListViewState>
        get() = _state

    fun getGames() {
        viewModelScope.launch(Dispatchers.IO) {

            _state.postValue(GameListViewState.Proccessing)

            _state.postValue(
                when (val result = dataSource.getGames()) {
                    is Either.Success -> GameListViewState.DataReceived(result.data)
                    is Either.Error -> GameListViewState.ErrorReceived(result.exception.toString())
                }
            )
        }
    }
}
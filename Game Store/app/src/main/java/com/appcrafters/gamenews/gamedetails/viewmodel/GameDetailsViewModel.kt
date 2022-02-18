package com.appcrafters.gamenews.gamedetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appcrafters.gamenews.base.data.GamesDataSource
import com.appcrafters.gamenews.base.functional.Either
import com.appcrafters.gamenews.gamedetails.view.GameDetailsViewState
import kotlinx.coroutines.launch

class GameDetailsViewModel(private val dataSource: GamesDataSource) : ViewModel() {
    private val _state = MutableLiveData<GameDetailsViewState>()
    val state: LiveData<GameDetailsViewState>
        get() = _state

    fun getGameById(id: Int) {
        viewModelScope.launch {
            _state.postValue(GameDetailsViewState.Proccessing)

            _state.postValue(
                when (val result = dataSource.getGameById(id)) {
                    is Either.Success -> GameDetailsViewState.DataReceived(result.data)
                    is Either.Error -> GameDetailsViewState.ErrorReceived(result.exception.toString())
                }
            )
        }
    }
}
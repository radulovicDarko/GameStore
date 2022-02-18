package com.appcrafters.gamenews.base.data

import com.example.games.model.Game
import com.example.games.model.GameDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GamesApiService {

    @GET("games")
    fun getGames(@Header("x-rapidapi-host") host: String, @Header("x-rapidapi-key") key: String): Call<List<Game>>

    @GET("game")
    fun getGameById(@Header("x-rapidapi-host") host: String, @Header("x-rapidapi-key") key: String, @Query("id") id: Int): Call<GameDetails>
}
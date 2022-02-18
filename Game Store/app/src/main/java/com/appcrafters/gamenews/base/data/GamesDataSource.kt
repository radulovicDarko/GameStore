package com.appcrafters.gamenews.base.data

import com.appcrafters.gamenews.base.functional.Either
import com.example.games.model.Game
import com.example.games.model.GameDetails
import retrofit2.Call
import retrofit2.awaitResponse

class GamesDataSource(private val apiService: GamesApiService) {
    companion object {
        private const val host = "free-to-play-games-database.p.rapidapi.com"
        private const val key = "ea9d745207msh8cd03420e084d49p1ac50ajsn5f5967a56706"
    }

    suspend fun getGames(): Either<List<Game>> = handleCall(apiService.getGames(host,key))

    suspend fun getGameById(id: Int): Either<GameDetails> = handleCall(apiService.getGameById(host,key,id))

    private suspend fun <T> handleCall(call: Call<T>): Either<T> {
        val response = call.awaitResponse()

        return if (response.isSuccessful) {
            Either.Success(response.body()!!)
        } else {
            Either.Error(Exception(response.message()))
        }
    }
}
package com.appcrafters.gamenews.base.data

object ApiServiceProvider {
    val gamesApiService = RetrofitBuilder.retrofit.create(GamesApiService::class.java)
}
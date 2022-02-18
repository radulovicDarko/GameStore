package com.appcrafters.gamenews.base.data

import android.util.Log
import com.example.games.model.Game
import org.json.JSONArray
import org.json.JSONException

object GamesParser {
    private const val TAG = "GamesParser"
    fun parse(json: String): List<Game> {
        val games = mutableListOf<Game>()

        try {
            val gamesJsonArray = JSONArray(json);

            for (i in 0 until gamesJsonArray.length()) {
                val jsonGame = gamesJsonArray.getJSONObject(i)

                val id = jsonGame.getInt("id")
                val title = jsonGame.getString("title")
                val thumbnail = jsonGame.getString("thumbnail")
                val short_description = jsonGame.getString("short_description")
                val game_url = jsonGame.getString("game_url")
                val genre = jsonGame.getString("genre")
                val platform = jsonGame.getString("platform")
                val publisher = jsonGame.getString("publisher")
                val developer = jsonGame.getString("developer")
                val release_date = jsonGame.getString("release_date")
                val freetogame_profile_url = jsonGame.getString("freetogame_profile_url")

                val game = Game(id, title, thumbnail, short_description, game_url, genre, platform, publisher, developer, release_date, freetogame_profile_url)
                games.add(game)
            }

        } catch (e: JSONException) {
            Log.e(TAG, e.toString())
        }

        return games
    }
}
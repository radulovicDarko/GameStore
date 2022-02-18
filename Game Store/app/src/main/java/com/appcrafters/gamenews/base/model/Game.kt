package com.example.games.model

data class Game(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_date: String,
    val freetogame_profile_url: String,
)

data class Review(
    val customerName: String,
    val customerImg: String,
    val stars: Int,
    val date: String,
    val description: String,
)

data class GameDetails(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val status: String,
    val short_description: String,
    val description: String,
    val game_url: String?,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val release_date: String,
    val freetogame_profile_url: String,
    val minimum_system_requirements: MinimumSystemRequirements,
    val screenshots: List<Screenshot>,
)

data class MinimumSystemRequirements(
    val os: String,
    val processor: String,
    val memory: String,
    val graphics: String,
    val storage: String,
)

data class Screenshot(
    val id: Int,
    val image: String,
)


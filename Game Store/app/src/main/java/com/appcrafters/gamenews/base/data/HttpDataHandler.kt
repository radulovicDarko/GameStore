package com.appcrafters.gamenews.base.data

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

object HttpDataHandler {

    private const val xRapidapiKey = "ea9d745207msh8cd03420e084d49p1ac50ajsn5f5967a56706"
    private const val xRapidapiHost = "free-to-play-games-database.p.rapidapi.com"

    fun getResponse(urlString: String): Result<String> {
        try {
            val url = URL(urlString)
            val urlConnection = url.openConnection() as HttpURLConnection

            urlConnection.setRequestProperty("x-rapidapi-host", xRapidapiHost)
            urlConnection.setRequestProperty("x-rapidapi-key", xRapidapiKey)

            if (urlConnection.responseCode == 200) {
                val inputStream = BufferedInputStream(urlConnection.inputStream)
                val reader = BufferedReader(InputStreamReader(inputStream))

                val builder = StringBuilder()
                var line = reader.readLine()

                while (line != null) {
                    builder.append(line)
                    line = reader.readLine()
                }

                val string = builder.toString()
                urlConnection.disconnect()
                return Result.Success(string)
            }

            return Result.Error(Exception("Error occurred - Response code: ${urlConnection.responseCode}"))
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}

package com.dam.wheatherapp

import com.dam.wheatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val API_KEY = "cd7e69f72550c9b90871b2804a05e3a4"
    }

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("lang") lang: String = "sp",
    ) : WeatherResponse
}
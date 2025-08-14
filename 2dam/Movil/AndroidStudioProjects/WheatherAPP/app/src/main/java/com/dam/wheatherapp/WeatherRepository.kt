package com.dam.wheatherapp

import com.dam.wheatherapp.model.WeatherResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    private val okHttpClient = HttpLoggingInterceptor().run {
        level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(this).build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(WeatherService::class.java)

    suspend fun getWeatherCity(city:String, units: String): WeatherResponse {
        return service.getWeather(city,units)
    }
}
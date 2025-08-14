package com.example.examenrodrigotapiador.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
object RemoteConnection {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()



    private val builder = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RemoteService = builder.create()
}
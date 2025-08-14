package edu.dam24.themealdbapi.model.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RemoteConnection {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()



    private val builder = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RemoteService = builder.create()


}
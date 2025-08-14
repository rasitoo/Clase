package edu.dam24.themealdbapi.model.server

import retrofit2.http.GET

interface RemoteService {

    @GET("categories.php")
    suspend fun getCategories(): RemoteResult
}
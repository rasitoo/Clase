package com.example.themealdb.model.server

import retrofit2.http.GET

/**
 * @author Rodrigo
 * @date 31 enero, 2025
 */
interface RemoteService {
    @GET("categories.php")
    suspend fun getCategories(): Category
}
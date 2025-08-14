package com.example.practicaexamen.api

import retrofit2.http.GET

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
interface RemoteService {

    @GET("categories.php")
    suspend fun getCategories(): RemoteResult
}
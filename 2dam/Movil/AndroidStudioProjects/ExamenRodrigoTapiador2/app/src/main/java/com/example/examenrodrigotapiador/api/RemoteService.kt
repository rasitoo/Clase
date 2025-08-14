package com.example.examenrodrigotapiador.api

import retrofit2.http.GET

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
interface RemoteService {
    @GET("users")
    suspend fun getCategories(): RemoteResult
}
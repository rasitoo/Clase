package com.example.myapplication.apirest

import com.example.myapplication.models.EventResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketmasterApi {

    @GET("discovery/v2/events")
    suspend fun getEvents(
        @Query("apikey") apiKey: String,
        @Query("city") city: String?,
        @Query("countryCode") countryCode: String = "ES",
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "date,asc"
    ): Response<EventResponse>
}

package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.apirest.RetrofitClient
import com.example.myapplication.models.ApiEvent
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.*


class ApiEventsViewModel : ViewModel() {

    private val _events = MutableLiveData<List<ApiEvent>>()
    val events: LiveData<List<ApiEvent>> = _events

    fun fetchEvents(city: String?) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getEvents(
                    apiKey = "TU_API_KEY_AQUÍ",
                    city = city
                )
                if (response.isSuccessful) {
                    _events.value = response.body()?.embedded?.events ?: emptyList()
                } else {
                    Log.e("API", "Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("API", "Excepción: ${e.message}")
            }
        }
    }
}

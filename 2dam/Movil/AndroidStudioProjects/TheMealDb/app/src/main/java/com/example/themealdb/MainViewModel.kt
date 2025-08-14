package com.example.themealdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themealdb.model.server.CategoryX
import com.example.themealdb.model.server.RemoteConnection.service
import kotlinx.coroutines.launch

/**
 * @author Rodrigo
 * @date 31 enero, 2025
 */
class MainViewModel : ViewModel() {
    private val _state = MutableLiveData<UiState>()
    val state : LiveData<UiState> get() = _state

    init {
        _state.value = UiState(loading = true)
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = service.getCategories()
                _state.value = _state.value?.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e: Exception){
                _state.value = _state.value?.copy(
                    loading = false,
                    error = "Error en la lectura de categorías: ${e.message}"
                )
            }
        }
    }




    data class UiState(
        val loading: Boolean = true,
        val list: List<CategoryX> = emptyList(),
        val error: String? = null
    )
}
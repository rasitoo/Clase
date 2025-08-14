package com.example.practicaexamen.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaexamen.api.RemoteConnection.service
import com.example.practicaexamen.models.Category
import kotlinx.coroutines.launch

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class CategoryViewModel: ViewModel() {
    private val _state = MutableLiveData<UiState>()
    val state : LiveData<UiState> get() = _state

    init {
        _state.value = UiState(loading = true) // Inicializa el estado
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = service.getCategories()
                _state.value = _state.value?.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            } catch (e: Exception) {
                _state.value = _state.value?.copy(
                    loading = false,
                    error = "Error en la lectura de categorías: ${e.message}"
                )
            }
        }
    }


    //data estado
    data class UiState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}
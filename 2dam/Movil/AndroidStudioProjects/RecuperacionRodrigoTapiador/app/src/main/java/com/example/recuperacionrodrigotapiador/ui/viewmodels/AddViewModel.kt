package com.example.recuperacionrodrigotapiador.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.recuperacionrodrigotapiador.db.Database
import com.example.recuperacionrodrigotapiador.models.Tarea
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(private val database: Database) : ViewModel() {
    private val _tareas = MutableLiveData<List<Tarea>>()
    val tareas: LiveData<List<Tarea>> get() = _tareas
    fun fetchTareas(){
        viewModelScope.launch {
            _tareas.value = database.dao().getAllTareas()
        }
    }
    fun filterDate(string: String): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.date.equals(string)
        } ?: emptyList()
    }
    fun deleteTarea(tarea: Tarea) {
        viewModelScope.launch(Dispatchers.IO) {
            database.dao().deleteTarea(tarea)
        }
    }

    suspend fun saveTarea(tarea: Tarea) {
        database.dao().insertTarea(tarea)

    }

    fun filterWork(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.category.equals("Trabajo")
        } ?: emptyList()
    }

    fun filterUrgent(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.category.equals("Urgente")
        } ?: emptyList()
    }

    fun filterPersonal(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.category.equals("Personal")
        } ?: emptyList()
    }

    fun filterEnd(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.state.equals("2131231282")
        } ?: emptyList()
    }

    fun filterProcess(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.state.equals("2131231287")
        } ?: emptyList()
    }

    fun filterShopping(): List<Tarea> {
        return _tareas.value?.filter { tarea ->
            tarea.category.equals("Compras")
        } ?: emptyList()
    }
}
@Suppress("UNCHECKED_CAST")
class AddViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
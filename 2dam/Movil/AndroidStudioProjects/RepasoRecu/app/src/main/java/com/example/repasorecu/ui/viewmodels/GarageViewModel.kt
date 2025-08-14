package com.example.repasorecu.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.repasorecu.db.Database
import com.example.repasorecu.models.Vehicle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GarageViewModel(private val database: Database) : ViewModel() {
    private val _vehicles = MutableLiveData<List<Vehicle>>()
    val vehicles: LiveData<List<Vehicle>> get() = _vehicles
    fun fetchVehicles(){
        viewModelScope.launch {
            _vehicles.value = database.dao().getAllVehicles()
        }
    }
    fun filter(string: String): List<Vehicle> {
        return _vehicles.value?.filter { vehicle ->
            val datePart = vehicle.entryDate.split("/")[0]
            datePart == string
        } ?: emptyList()
    }
    fun deleteVehicle(vehicle: Vehicle) {
        viewModelScope.launch(Dispatchers.IO) {
            database.dao().deleteVehicle(vehicle)
        }
    }

    suspend fun saveVehicle(vehicle: Vehicle) {
        database.dao().insertVehicle(vehicle)

    }
}
@Suppress("UNCHECKED_CAST")
class GarageViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GarageViewModel::class.java)) {
            return GarageViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
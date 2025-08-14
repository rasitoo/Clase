package com.example.practicaexamen.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicaexamen.models.Location

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class LocationViewModel: ViewModel() {
    private val _location = MutableLiveData<Location?>()
    val location: LiveData<Location?> get() = _location

    fun updateLocation(newLocation: Location){
        _location.value = newLocation
    }
}
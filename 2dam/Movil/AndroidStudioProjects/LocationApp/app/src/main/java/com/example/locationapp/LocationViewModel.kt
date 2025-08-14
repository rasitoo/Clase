package com.example.locationapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Rodrigo
 * @date 03 febrero, 2025
 */
class LocationViewModel: ViewModel(){
    private val _location = MutableLiveData<LocationData?>()
    val location: LiveData<LocationData?> get() = _location

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }
}
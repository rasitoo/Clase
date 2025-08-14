package com.example.fragmento22_11

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Rodrigo
 * @date 22 noviembre, 2024
 */
class ItemViewModel : ViewModel() {
    private val _mutableDato = MutableLiveData<String>()

    val mutableDato: LiveData<String>
        get() = _mutableDato

    fun mostrarDato(dato:String){
        _mutableDato.value = dato
    }
}
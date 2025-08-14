package com.example.examenrodrigotapiador.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ItemViewModel : ViewModel() {
    private val _mutableDato = MutableLiveData<String>()

    val mutableDato: LiveData<String>
        get() = _mutableDato

    fun mostrarDato(dato:String){
        _mutableDato.value = dato
    }
}
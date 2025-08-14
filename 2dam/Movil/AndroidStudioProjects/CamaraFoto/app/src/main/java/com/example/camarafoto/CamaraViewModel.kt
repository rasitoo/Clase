package com.example.camarafoto

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CamaraViewModel: ViewModel() {
    private val _photoUri = MutableLiveData<Uri?>()
    val photoUri: LiveData<Uri?> get() = _photoUri

    fun updatePhotoUri(uri: Uri?){
        _photoUri.value = uri
    }
}

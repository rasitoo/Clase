package com.example.practicaexamen.ui.viewModels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class ProfileViewModel: ViewModel() {

    private val _photoUri = MutableLiveData<Uri>()
    val photoUri: MutableLiveData<Uri> get() = _photoUri

    fun updatePhotoUri(uri: Uri){
        _photoUri.value=uri
    }

}

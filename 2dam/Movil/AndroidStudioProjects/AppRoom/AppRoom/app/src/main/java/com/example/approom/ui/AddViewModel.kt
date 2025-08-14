package com.example.approom.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.approom.db.Contact
import com.example.approom.db.ContactDao
import kotlinx.coroutines.launch

class AddViewModel(private val contactDao: ContactDao): ViewModel() {
    //funciones
    fun insert(contact: Contact) = viewModelScope.launch {
        contactDao.insertContact(contact)
    }

    fun update(contact: Contact) = viewModelScope.launch {
        contactDao.updateContact(contact)
    }

    fun allByIdContact(id:Int) : LiveData<Contact>{
        return contactDao.getById(id)
    }

}

@Suppress("UNCHECKED_CAST")
class AddViewModelFactory(private val contactDao: ContactDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddViewModel(contactDao) as T
    }
}
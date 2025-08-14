package com.example.approom.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.approom.db.Contact
import com.example.approom.db.ContactDao
import kotlinx.coroutines.launch

class HomeViewModel(private val contactDao: ContactDao) : ViewModel() {

    //listar
    val allContacts : LiveData<List<Contact>> = contactDao.getAllContact()

    //eliminar
    fun delete(contact: Contact) = viewModelScope.launch {
        contactDao.deleteContact(contact)
    }

}

//factory
@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(private val contactDao: ContactDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(contactDao) as T
    }
}
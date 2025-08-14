package com.example.repasoanteriorcurso.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.repasoanteriorcurso.App
import com.example.repasoanteriorcurso.database.VotosDatabase
import com.example.repasoanteriorcurso.models.Registro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class ListadoViewModel(private val database: VotosDatabase) : ViewModel() {

    private val _registers = MutableLiveData<List<Registro>>()
    val registers: LiveData<List<Registro>> get() = _registers

    fun fetchRegisters() {
        viewModelScope.launch(Dispatchers.IO) {
            val registers = App.database.registroDao().findAll()
            withContext(Dispatchers.Main) {
                _registers.value = registers
            }
        }
    }

    fun filter(string: String) : List<Registro> {
        return _registers.value?.filter { Register -> Register.ciudad == string } ?:   emptyList()
    }

//    fun deleteReservation(register: Registro) {
//        viewModelScope.launch(Dispatchers.IO) {
//            database.registroDao().
//        }
//    }

}

@Suppress("UNCHECKED_CAST")
class ListadoViewModelFactory(private val database: VotosDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListadoViewModel::class.java)) {
            return ListadoViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
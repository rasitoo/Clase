package com.example.examenrodrigotapiador.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.examenrodrigotapiador.db.Database
import com.example.examenrodrigotapiador.models.Appointment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalendarViewModel(private val database: Database) : ViewModel() {
    private val _appointments = MutableLiveData<List<Appointment>>()
    val appointments: LiveData<List<Appointment>> get() = _appointments
    fun fetchAppointments(){
        viewModelScope.launch {
            _appointments.value = database.daoAppointment().getAllAppointments()
        }
    }
    fun filter(string: String) : List<Appointment> {
        return _appointments.value?.filter { Appointment -> Appointment.date.equals(string) } ?:   emptyList()
    }
    fun deleteAppointment(appointment: Appointment) {
        viewModelScope.launch(Dispatchers.IO) {
            database.daoAppointment().deleteAppointment(appointment)
        }
    }

    suspend fun saveAppointment(appointment: Appointment) {
        database.daoAppointment().insertAppointment(appointment)

    }
}
@Suppress("UNCHECKED_CAST")
class CalendarViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            return CalendarViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
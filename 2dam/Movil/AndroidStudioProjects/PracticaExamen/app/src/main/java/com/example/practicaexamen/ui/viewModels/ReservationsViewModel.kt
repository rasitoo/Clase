package com.example.practicaexamen.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practicaexamen.db.Database
import com.example.practicaexamen.models.Reservation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class ReservationsViewModel(private val database: Database) : ViewModel() {

    private val _reservations = MutableLiveData<List<Reservation>>()
    val reservations: LiveData<List<Reservation>> get() = _reservations

    fun fetchReservations() {
        viewModelScope.launch {
            _reservations.value = database.daoReservation().getAllReservations()
        }
    }

    fun filter(int: Int) : List<Reservation> {
        return _reservations.value?.filter { Reservation -> Reservation.restaurant == int } ?:   emptyList()
    }

    fun deleteReservation(reservation: Reservation) {
        viewModelScope.launch(Dispatchers.IO) {
            database.daoReservation().deleteReservation(reservation)
        }
    }

}

@Suppress("UNCHECKED_CAST")
class ReservationsViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReservationsViewModel::class.java)) {
            return ReservationsViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
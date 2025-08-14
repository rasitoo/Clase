package com.example.practicaexamen.ui.viewModels

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practicaexamen.db.Database
import com.example.practicaexamen.models.Reservation
import com.example.practicaexamen.models.Restaurant
import kotlinx.coroutines.launch

/**
 * @author Rodrigo
 * @date 19 febrero, 2025
 */
class ReservationViewModel(private val database: Database) : ViewModel() {
    private val _selectedRestaurant = MutableLiveData<Restaurant?>()
    val selectedRestaurant: MutableLiveData<Restaurant?> get() = _selectedRestaurant

    fun setSelectedRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            try {
                val restaurant = database.daoRestaurant().getRestaurantById(restaurantId)
                _selectedRestaurant.value = restaurant
            } catch (e: Exception) {
                // Manejo de errores, por ejemplo, mostrar un mensaje de error
                _selectedRestaurant.value = null
            }
        }
    }

    suspend fun saveReservation(reserva: Reservation) {
        database.daoReservation().insertReservation(reserva)
    }

}
@Suppress("UNCHECKED_CAST")
class ReservationViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReservationViewModel::class.java)) {
            return ReservationViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
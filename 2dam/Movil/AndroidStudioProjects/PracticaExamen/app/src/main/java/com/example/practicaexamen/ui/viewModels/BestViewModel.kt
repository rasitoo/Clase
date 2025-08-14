package com.example.practicaexamen.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practicaexamen.R
import com.example.practicaexamen.db.Database
import com.example.practicaexamen.models.Restaurant
import kotlinx.coroutines.launch

/**
 * @author Rodrigo
 * @date 19 febrero, 2025
 */
class BestViewModel(private val database: Database) : ViewModel() {


    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> get() = _restaurants


    fun fetchRestaurants() {
        viewModelScope.launch {
            _restaurants.value = database.daoRestaurant().getAllRestaurants()
        }
    }

    fun generateCategoriesAndRestaurants() {
        viewModelScope.launch {
            val categories = listOf(
                "buffet",
                "especialidad",
                "gourmet",
                "llevar",
                "rapida",
                "tematica"
            )

            val restaurants = (1..10).map {
                Restaurant(
                    id = it,
                    name = "Restaurante $it",
                    category = categories[it % categories.size],
                    imageResId = when (categories[it % categories.size]) {
                        "buffet" -> R.drawable.restaurante_buffet
                        "especialidad" -> R.drawable.restaurante_especialidad
                        "gourmet" -> R.drawable.restaurante_gourmet
                        "llevar" -> R.drawable.restaurante_llevar
                        "rapida" -> R.drawable.restaurante_rapida
                        "tematica" -> R.drawable.restaurante_tematica
                        else -> 0
                    }
                )
            }

            database.daoRestaurant().insertRestaurants(restaurants)
        }
    }
    fun reloadDatabase() {
        viewModelScope.launch {
            database.daoRestaurant().clearRestaurants()

            // Repopulate the database
            generateCategoriesAndRestaurants()
        }
    }
}
@Suppress("UNCHECKED_CAST")
class BestViewModelFactory(private val database: Database) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BestViewModel::class.java)) {
            return BestViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

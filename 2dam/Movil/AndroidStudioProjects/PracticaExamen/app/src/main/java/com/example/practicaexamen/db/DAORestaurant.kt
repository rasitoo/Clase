package com.example.practicaexamen.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.practicaexamen.models.Restaurant

@Dao
interface DAORestaurant {

    @Insert
    suspend fun insertRestaurant(restaurant: Restaurant)

    @Insert
    suspend fun insertRestaurants(restaurants: List<Restaurant>)

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM table_restaurants WHERE id = :id")
    suspend fun getRestaurantById(id: Int): Restaurant?

    @Query("SELECT * FROM table_restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @Query("DELETE FROM table_restaurants")
    suspend fun clearRestaurants()
}
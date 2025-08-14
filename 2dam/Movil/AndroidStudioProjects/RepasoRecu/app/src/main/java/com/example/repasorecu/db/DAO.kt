package com.example.repasorecu.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.repasorecu.models.User
import com.example.repasorecu.models.Vehicle

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
 */
@Dao
interface DAO {
    @Insert
    suspend fun insertVehicle(vehicle: Vehicle)

    @Insert
    suspend fun insertVehicles(vehicles: List<Vehicle>)

    @Update
    suspend fun updateVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    @Query("SELECT * FROM table_vehicles WHERE id = :id")
    suspend fun getVehicleById(id: Int): Vehicle?

    @Query("SELECT * FROM table_vehicles")
    suspend fun getAllVehicles(): List<Vehicle>

    @Query("DELETE FROM table_vehicles")
    suspend fun clearAppointments()
    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertUsers(users: List<User>)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM table_users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM table_users")
    suspend fun getAllUsers(): List<User>

    @Query("DELETE FROM table_users")
    suspend fun clearUsers()

}
package com.example.examenrodrigotapiador.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.examenrodrigotapiador.models.User

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
@Dao

interface DAOUser {
    @Insert
    suspend fun insertUser(restaurant: User)

    @Insert
    suspend fun insertUsers(restaurants: List<User>)

    @Update
    suspend fun updateUser(restaurant: User)

    @Delete
    suspend fun deleteUser(restaurant: User)

    @Query("SELECT * FROM table_users WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Query("SELECT * FROM table_users")
    suspend fun getAllUsers(): List<User>

    @Query("DELETE FROM table_users")
    suspend fun clearUsers()
}
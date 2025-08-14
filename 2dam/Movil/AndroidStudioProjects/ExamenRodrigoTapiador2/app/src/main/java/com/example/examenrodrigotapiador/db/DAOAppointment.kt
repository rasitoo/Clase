package com.example.examenrodrigotapiador.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.examenrodrigotapiador.models.Appointment

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
@Dao

interface DAOAppointment {
    @Insert
    suspend fun insertAppointment(restaurant: Appointment)

    @Insert
    suspend fun insertAppointments(restaurants: List<Appointment>)

    @Update
    suspend fun updateAppointment(restaurant: Appointment)

    @Delete
    suspend fun deleteAppointment(restaurant: Appointment)

    @Query("SELECT * FROM table_appointments WHERE id = :id")
    suspend fun getAppointmentById(id: Int): Appointment?

    @Query("SELECT * FROM table_appointments")
    suspend fun getAllAppointments(): List<Appointment>

    @Query("DELETE FROM table_appointments")
    suspend fun clearAppointments()
}
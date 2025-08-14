package com.example.practicaexamen.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.example.practicaexamen.models.Reservation

@Dao
interface DAOReservation {

    @Insert
    suspend fun insertReservation(reservation: Reservation)

    @Update
    suspend fun updateReservation(reservation: Reservation)

    @Delete
    suspend fun deleteReservation(reservation: Reservation)

    @Query("SELECT * FROM table_reservations WHERE id = :id")
    suspend fun getReservationById(id: Int): Reservation?

    @Query("SELECT * FROM table_reservations")
    suspend fun getAllReservations(): List<Reservation>
}
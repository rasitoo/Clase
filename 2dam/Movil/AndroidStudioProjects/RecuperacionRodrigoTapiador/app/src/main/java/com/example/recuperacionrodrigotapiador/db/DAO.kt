package com.example.recuperacionrodrigotapiador.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.recuperacionrodrigotapiador.models.Tarea

/**
 * @author Rodrigo
 * @date 14 marzo, 2025
 */

@Dao
interface DAO {

    @Insert
    suspend fun insertTarea(reservation: Tarea)

    @Update
    suspend fun updateTarea(reservation: Tarea)

    @Delete
    suspend fun deleteTarea(reservation: Tarea)

    @Query("SELECT * FROM table_tareas WHERE id = :id")
    suspend fun getTareaById(id: Int): Tarea?

    @Query("SELECT * FROM table_tareas")
    suspend fun getAllTareas(): List<Tarea>
}
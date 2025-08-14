package com.example.roomcrud

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * @author Rodrigo
 * @date 16 diciembre, 2024
 */
@Dao
interface DatoDao {

    //funciones
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dato: Dato)

    @Update
    suspend fun update(dato: Dato)

    @Delete
    suspend fun delete(dato: Dato)

    @Query("SELECT * FROM table_dato WHERE id = :id")
    suspend fun getDato(id: Int): MutableList<Dato>

    @Query("SELECT * FROM table_dato ORDER BY name ASC")
    suspend fun getAllDatos(): MutableList<Dato>
}
package com.example.repasoanteriorcurso.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.repasoanteriorcurso.models.Ciudad

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
 */
@Dao
interface CiudadDao {
    @Query("SELECT * FROM ciudad")
    fun findAll(): List<Ciudad>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(ciudad: Ciudad)
}
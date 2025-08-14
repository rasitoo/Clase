package com.example.repasoanteriorcurso.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.repasoanteriorcurso.models.Registro

/**
 * @author Rodrigo
 * @date 12 marzo, 2025
 */
@Dao
interface RegistroDao {
    @Query("SELECT * FROM registro")
    fun findAll(): List<Registro>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(registro: Registro)
}
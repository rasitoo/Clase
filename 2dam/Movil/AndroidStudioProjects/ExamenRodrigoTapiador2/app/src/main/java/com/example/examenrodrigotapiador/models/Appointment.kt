package com.example.examenrodrigotapiador.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
@Entity(
    tableName = "table_appointments"
)
data class Appointment(

    @ColumnInfo(name = "asignatura")
    val asignatura: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "aula")
    val aula: String,
    @ColumnInfo(name = "hora")
    val hora: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)

package com.example.examenrodrigotapiador.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
@Entity(
    tableName = "table_users"
)
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "number")
    val number: String,
    @ColumnInfo(name = "imageResId")
    val imageResId: Int


)

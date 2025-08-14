package com.example.roomcrud

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 16 diciembre, 2024
 */
@Entity(tableName = "table_dato")
data class Dato(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)

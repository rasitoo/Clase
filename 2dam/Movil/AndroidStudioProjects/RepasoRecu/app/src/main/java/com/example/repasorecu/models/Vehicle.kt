package com.example.repasorecu.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.type.DateTime

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
@Entity(
    tableName = "table_vehicles"
)
data class Vehicle(

    @ColumnInfo(name = "matricula")
    val matricula: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "state")
    val state: String,
    @ColumnInfo(name = "entryDate")
    val entryDate: String,
    @ColumnInfo(name = "priority")
    val priority: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)

package com.example.recuperacionrodrigotapiador.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 14 marzo, 2025
 */
@Entity(
    tableName = "table_tareas"
)
data class Tarea(

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "state")
    val state: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "priority")
    val priority: String,
    @ColumnInfo(name = "category")
    val category: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
)

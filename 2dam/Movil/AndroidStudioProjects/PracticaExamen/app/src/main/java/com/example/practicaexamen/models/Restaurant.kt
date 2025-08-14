package com.example.practicaexamen.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 19 febrero, 2025
 */
@Entity(
    tableName = "table_restaurants"
)
data class Restaurant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "imageResId")
    val imageResId: Int
)

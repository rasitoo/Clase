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
    tableName = "table_reservations",
    foreignKeys = [ForeignKey(
        entity = Restaurant::class,
        parentColumns = ["id"],
        childColumns = ["restaurantId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Reservation(

    @ColumnInfo(name = "numPersonas")
    val numPersons: Int,
    @ColumnInfo(name = "fecha")
    val date: String,
    @ColumnInfo(name = "hora")
    val time: String,
    @ColumnInfo(name = "restaurantId")
    val restaurant: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int?
)

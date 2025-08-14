package com.example.roomcrud

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Rodrigo
 * @date 16 diciembre, 2024
 */
@Database(entities = [Dato::class], version = 1, exportSchema = false)
abstract class DatoDatabase: RoomDatabase() {
    abstract fun datoDao(): DatoDao
}
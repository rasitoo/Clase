package com.example.recuperacionrodrigotapiador.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recuperacionrodrigotapiador.models.Tarea

/**
 * @author Rodrigo
 * @date 14 marzo, 2025
 */

@Database(entities = [ Tarea::class], version = 2)
abstract class Database : RoomDatabase() {
    abstract fun dao(): DAO
    companion object {
        @Volatile
        private var INSTANCE: com.example.recuperacionrodrigotapiador.db.Database? = null

        fun getInstance(context: Context): com.example.recuperacionrodrigotapiador.db.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.recuperacionrodrigotapiador.db.Database::class.java,
                    "teachers_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
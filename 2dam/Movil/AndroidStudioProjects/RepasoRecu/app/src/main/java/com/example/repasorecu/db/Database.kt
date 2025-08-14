package com.example.repasorecu.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repasorecu.models.User
import com.example.repasorecu.models.Vehicle

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
 */

@Database(entities = [ Vehicle::class, User::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun dao(): DAO
    companion object {
        @Volatile
        private var INSTANCE: com.example.repasorecu.db.Database? = null

        fun getInstance(context: Context): com.example.repasorecu.db.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.repasorecu.db.Database::class.java,
                    "garage_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
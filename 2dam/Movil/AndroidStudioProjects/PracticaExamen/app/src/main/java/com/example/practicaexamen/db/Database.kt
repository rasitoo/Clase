package com.example.practicaexamen.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practicaexamen.models.Reservation
import com.example.practicaexamen.models.Restaurant

@Database(entities = [ Reservation::class, Restaurant::class], version = 2)
abstract class Database : RoomDatabase() {
    abstract fun daoReservation(): DAOReservation
    abstract fun daoRestaurant(): DAORestaurant
    companion object {
        @Volatile
        private var INSTANCE: com.example.practicaexamen.db.Database? = null

        fun getInstance(context: Context): com.example.practicaexamen.db.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.practicaexamen.db.Database::class.java,
                    "restaurant_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
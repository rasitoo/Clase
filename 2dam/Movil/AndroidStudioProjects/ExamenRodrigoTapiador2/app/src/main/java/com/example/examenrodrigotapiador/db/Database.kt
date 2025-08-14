package com.example.examenrodrigotapiador.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenrodrigotapiador.models.Appointment
import com.example.examenrodrigotapiador.models.User

@Database(entities = [ Appointment::class, User::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun daoAppointment(): DAOAppointment
    abstract fun daoUser(): DAOUser
    companion object {
        @Volatile
        private var INSTANCE: com.example.examenrodrigotapiador.db.Database? = null

        fun getInstance(context: Context): com.example.examenrodrigotapiador.db.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.examenrodrigotapiador.db.Database::class.java,
                    "users_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
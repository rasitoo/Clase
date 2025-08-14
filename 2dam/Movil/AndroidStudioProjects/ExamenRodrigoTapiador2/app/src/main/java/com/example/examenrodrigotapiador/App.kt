package com.example.examenrodrigotapiador

import android.app.Application
import androidx.room.Room
import com.example.examenrodrigotapiador.db.Database

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
class App : Application() {

    companion object {
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            Database::class.java,
            "users_database"
        ).fallbackToDestructiveMigration().build()
    }

}
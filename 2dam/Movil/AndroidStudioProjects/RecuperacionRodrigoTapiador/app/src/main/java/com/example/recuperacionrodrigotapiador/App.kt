package com.example.recuperacionrodrigotapiador

import android.app.Application
import androidx.room.Room
import com.example.recuperacionrodrigotapiador.db.Database

/**
 * @author Rodrigo
 * @date 14 marzo, 2025
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
            "teachers_database"
        ).fallbackToDestructiveMigration().build()
    }

}
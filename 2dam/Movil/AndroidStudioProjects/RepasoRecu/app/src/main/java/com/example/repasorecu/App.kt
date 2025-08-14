package com.example.repasorecu

import android.app.Application
import androidx.room.Room
import com.example.repasorecu.db.Database

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
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
            "garage_database"
        ).fallbackToDestructiveMigration().build()
    }

}
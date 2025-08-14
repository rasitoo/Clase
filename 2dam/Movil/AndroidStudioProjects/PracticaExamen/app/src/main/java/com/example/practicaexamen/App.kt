package com.example.practicaexamen

import com.example.practicaexamen.db.Database
import android.app.Application
import androidx.room.Room

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
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
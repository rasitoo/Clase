package com.example.repasoanteriorcurso

import android.app.Application
import androidx.room.Room
import com.example.repasoanteriorcurso.database.VotosDatabase

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
 */
class App : Application() {

    companion object {
        lateinit var database: VotosDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            VotosDatabase::class.java,
            "users_database"
        ).fallbackToDestructiveMigration().build()
    }

}
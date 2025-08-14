package com.example.approom

import android.app.Application
import androidx.room.Room
import com.example.approom.db.DatabaseContact

class App : Application() {
    companion object {
        lateinit var db: DatabaseContact
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(this,
            DatabaseContact::class.java,
            "contacto-db").build()


    }
}
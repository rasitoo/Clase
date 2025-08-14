package com.ev2.ContactoRoom

import android.app.Application
import androidx.room.Room
import com.ev2.ContactoRoom.db.ContactDao
import com.ev2.ContactoRoom.db.ContactDataBase

class App : Application() {

    companion object{
        lateinit var db:  ContactDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this,
        ContactDataBase::class.java,
        "contacto-db").build()
    }
}

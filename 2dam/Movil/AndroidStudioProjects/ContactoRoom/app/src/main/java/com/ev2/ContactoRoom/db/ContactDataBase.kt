package com.ev2.ContactoRoom.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(version = 1, entities = [Contact::class])
abstract class ContactDataBase : RoomDatabase() {
    // Unir el dao
    abstract fun contactDao(): ContactDao
}
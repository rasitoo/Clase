package com.example.approom.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class DatabaseContact : RoomDatabase(){
    abstract fun contactDao(): ContactDao

}
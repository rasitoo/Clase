package com.example.approom.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM table_contact")
     fun getAllContact():LiveData<List<Contact>>

    @Query("SELECT * FROM table_contact WHERE id = :id")
     fun getById(id:Int):LiveData<Contact>

}
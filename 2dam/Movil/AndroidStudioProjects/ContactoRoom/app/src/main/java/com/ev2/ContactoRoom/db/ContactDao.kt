package com.ev2.ContactoRoom.db

import androidx.room.*

@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contact)
    @Delete
    suspend fun delete(contact: Contact)
    @Update
    suspend fun update(contact: Contact)
    @Query("SELECT * FROM table_contact")
    suspend fun getAll(): List<Contact>
    @Query("SELECT * FROM table_contact WHERE id= :id")
    suspend fun getById(id: Int): Contact
}
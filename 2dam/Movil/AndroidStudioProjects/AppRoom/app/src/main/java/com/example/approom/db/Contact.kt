package com.example.approom.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("table_contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val phone: String,
    val image: String
)

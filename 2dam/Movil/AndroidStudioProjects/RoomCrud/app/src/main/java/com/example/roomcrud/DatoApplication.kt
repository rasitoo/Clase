package com.example.roomcrud

import android.app.Application
import androidx.room.Room

/**
 * @author Rodrigo
 * @date 16 diciembre, 2024
 */
class DatoApplication: Application(){
    //componente Singeton nos aseguramos una sola instancia y proporciona un punto de acceso
    companion object {
        lateinit var database: DatoDatabase
    }
    override fun onCreate(){
        super.onCreate()
        database = Room.databaseBuilder(this,::Dato)
    }
}

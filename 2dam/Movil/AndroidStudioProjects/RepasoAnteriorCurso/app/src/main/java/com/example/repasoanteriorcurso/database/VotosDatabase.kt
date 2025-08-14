package com.example.repasoanteriorcurso.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repasoanteriorcurso.models.Ciudad
import com.example.repasoanteriorcurso.models.Registro

/**
 * @author Rodrigo
 * @date 12 marzo, 2025
 */
@Database(entities = [Registro::class, Ciudad::class], version = 2, exportSchema = false)
abstract class VotosDatabase : RoomDatabase() {
    abstract fun registroDao(): RegistroDao
    abstract fun ciudadDao(): CiudadDao

    companion object {
        @Volatile
        private var INSTANCE: VotosDatabase? = null

        fun getInstance(context: Context): VotosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VotosDatabase::class.java,
                    "votes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
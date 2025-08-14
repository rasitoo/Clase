package com.example.repasoanteriorcurso.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 12 marzo, 2025
 */
@Entity
data class Ciudad(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val nombre: String,
) {
    var votosEmitidos: Int = 0
    var votosBlancos: Int = 0
    var votosNulos: Int = 0
}
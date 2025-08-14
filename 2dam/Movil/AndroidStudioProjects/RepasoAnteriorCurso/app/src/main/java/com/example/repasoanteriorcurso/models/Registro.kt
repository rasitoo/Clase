package com.example.repasoanteriorcurso.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rodrigo
 * @date 12 marzo, 2025
 */
@Entity
data class Registro(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val ciudad: String? = null,
    val distrito: String? = null,
    val mesa: Int = 0,
    val votosEmitidos: Int = 0,
    val votosBlancos: Int = 0,
    val votosNulos: Int = 0
)
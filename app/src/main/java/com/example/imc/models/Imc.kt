package com.example.imc.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "medicoes")
data class Imc(

    @PrimaryKey
    val id: String,
    val nomePessoa: String,
    val pesoEmKg: String,
    val alturaEmMetros: String,
    val imc: Float,
    val dataRegistro: String
    )
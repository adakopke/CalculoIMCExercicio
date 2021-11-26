package com.example.imc

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imc.dao.ImcDao
import com.example.imc.models.Imc


@Database(entities = arrayOf(Imc::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun imcDao(): ImcDao

}

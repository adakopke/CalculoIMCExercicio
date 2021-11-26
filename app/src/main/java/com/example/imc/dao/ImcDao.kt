package com.example.imc.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imc.models.Imc

    @Dao
    interface ImcDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun salvar(imc: Imc)

        @Query("SELECT * FROM medicoes")
        fun buscarMedicoes() : List<Imc>
}
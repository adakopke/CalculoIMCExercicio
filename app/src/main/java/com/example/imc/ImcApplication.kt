package com.example.imc

import android.app.Application
import androidx.room.Room

class ImcApplication: Application()  {

    @Override
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDataBase::class.java, "imc_db3")
            .allowMainThreadQueries().build()
    }

    companion object{
        var database: AppDataBase? = null
    }

}
package com.example.waterapp

import android.app.Application
import androidx.room.Room
import com.example.waterapp.data.WaterDB
import ru.terrakok.cicerone.Cicerone

class WaterApplication : Application() {
    private val cicerone = Cicerone.create()
    val router = cicerone.router
    val navigatorHolder = cicerone.navigatorHolder
    lateinit var database: WaterDB

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        database = Room.databaseBuilder(
            applicationContext,
            WaterDB::class.java, "water"
        )
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        internal lateinit var INSTANCE: WaterApplication
            private set
    }
}
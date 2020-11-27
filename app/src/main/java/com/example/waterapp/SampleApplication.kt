package com.example.waterapp

import android.app.Application
import ru.terrakok.cicerone.Cicerone

class SampleApplication : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: SampleApplication
            private set
    }
}
package com.example.waterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = SupportAppNavigator(this, R.id.rootContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        SampleApplication.INSTANCE.navigatorHolder.setNavigator(navigator)
        SampleApplication.INSTANCE.router.newRootScreen(Screens.GeneralScreen)
    }

    override fun onPause() {
        SampleApplication.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }
}
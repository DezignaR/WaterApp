package com.example.waterapp

import androidx.fragment.app.Fragment
import com.example.waterapp.data.WaterData
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object GeneralScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = GeneralFragment()
    }

    data class HistoryScreen(val getAllDb: () -> List<WaterData>) : SupportAppScreen() {
        override fun getFragment(): Fragment? = HistoryFragment()
    }
}
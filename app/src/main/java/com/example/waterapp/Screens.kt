package com.example.waterapp

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object GeneralScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = GeneralFragment()
    }

    object HistoryScreen : SupportAppScreen() {
        override fun getFragment(): Fragment? = HistoryFragment()
    }
}
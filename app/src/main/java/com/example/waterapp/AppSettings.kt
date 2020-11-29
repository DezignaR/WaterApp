package com.example.waterapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.chibatching.kotpref.KotprefModel

object AppSettings : KotprefModel() {
    var volume by intPref()

    fun ViewGroup.inflate(@LayoutRes layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)


}
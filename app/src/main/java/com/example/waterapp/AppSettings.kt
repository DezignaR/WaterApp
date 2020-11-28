package com.example.waterapp

import com.chibatching.kotpref.KotprefModel

object AppSettings : KotprefModel() {
    var volume by intPref()
}
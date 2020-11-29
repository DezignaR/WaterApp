package com.example.waterapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(DateConverter::class)
@Database(entities = [WaterData::class], version = 1)
abstract class WaterDB : RoomDatabase() {
    abstract fun waterDataDao(): WaterDataDao
}
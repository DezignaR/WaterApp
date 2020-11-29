package com.example.waterapp.data

import androidx.room.*
import java.util.*

@Entity
data class WaterData(
    @PrimaryKey(autoGenerate = true) public val id: Int = 0,
    @ColumnInfo(name = "data") public var date: Date,
    @ColumnInfo(name = "volume") public var volume: Int
)

@Dao
interface WaterDataDao {
    @Query("SELECT * FROM waterData")
    fun getAll(): List<WaterData>

    @Query("SELECT * FROM waterData WHERE :date ")
    fun getAllByDate(date: Long): List<WaterData>

    @Insert
    fun insertAll(vararg waterData: WaterData)

    @Delete
    fun delete(waterData: WaterData)
}

class DateConverter {
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
    @TypeConverter
    fun timestampToDate(timestamp: Long?): Date? = Date(timestamp!!)
}
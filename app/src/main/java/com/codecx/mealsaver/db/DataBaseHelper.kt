package com.codecx.mealsaver.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codecx.mealsaver.dataclasses.LocalDataDataClass
import com.codecx.mealsaver.dataclasses.Meal

@Database(entities = [LocalDataDataClass::class,Meal::class], version = 1)
abstract class DataBaseHelper : RoomDatabase() {
    abstract fun dao(): DataBaseInterFace
}
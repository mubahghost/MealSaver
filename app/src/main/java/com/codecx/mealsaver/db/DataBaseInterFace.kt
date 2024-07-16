package com.codecx.mealsaver.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codecx.mealsaver.dataclasses.LocalDataDataClass
import com.codecx.mealsaver.dataclasses.Meal

@Dao
interface DataBaseInterFace {
    @Insert
    fun insertData(value:LocalDataDataClass)
    @Insert
    fun insertMeal(value:Meal)

    @Query("Select * from mealTblTwo ")
    fun loadData(): List<Meal>
}
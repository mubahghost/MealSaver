package com.codecx.mealsaver.dataclasses


import com.google.gson.annotations.SerializedName

data class MealDataClass(
    @SerializedName("meals")
    var meals: List<Meal>?=null
)
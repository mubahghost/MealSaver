package com.codecx.mealsaver.api


import com.codecx.mealsaver.dataclasses.MealDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("search.php")
    fun searchMeal(@Query("s") searchVar: String): Call<MealDataClass>

}
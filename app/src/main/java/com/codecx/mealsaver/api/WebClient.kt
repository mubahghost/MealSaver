package com.codecx.mealsaver.api

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebClient (val context: Context) {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    private var myApi: API? = null

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        myApi = retrofit.create(API::class.java)
    }

    fun api(): API? {
        return myApi
    }

}
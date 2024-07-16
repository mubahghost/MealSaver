package com.codecx.mealsaver.db

import android.content.Context
import android.util.JsonReader
import android.util.Log
import androidx.room.Room
import com.codecx.mealsaver.R
import com.codecx.mealsaver.dataclasses.LocalDataDataClass
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.dataclasses.MealDataClass
import com.example.pokemon.interfaces.ResultCall
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.Reader

class DataBaseUtil(val context: Context) {
    fun addData(resultCall: ResultCall<String>) {
        try {
            val listData = getDataList()
            listData.forEach {
                mDataBaseHelper?.dao()?.insertData(it)
            }
            resultCall.resultSuccess("Add Successful")
        } catch (ex: java.lang.Exception) {
            Log.d("exceojo", ex.message.toString())
            resultCall.onFail(ex.message ?: "")
        }
    }

    private fun getDataList(): Array<LocalDataDataClass> {
        val inputStream = context.resources.openRawResource(R.raw.localdata)
        val text = inputStream.bufferedReader().use(BufferedReader::readText)
        val list = Gson().fromJson(text, Array<LocalDataDataClass>::class.java)
        return list
    }

    fun addMeal(loadedData: MealDataClass, resultCall: ResultCall<String>) {
        try {
            loadedData.meals?.forEach {

                mDataBaseHelper?.dao()?.insertMeal(it)
            }
            resultCall.resultSuccess("Add successful")
        } catch (ex: java.lang.Exception) {
            resultCall.onFail("Fail to add")
        }
    }

    fun loadData():List<Meal> {
        return mDataBaseHelper?.dao()?.loadData()?: listOf()
    }


    private var mDataBaseHelper: DataBaseHelper? = null

    init {
        mDataBaseHelper = Room.databaseBuilder(context, DataBaseHelper::class.java, "AppDataBase")
            .fallbackToDestructiveMigration()
            .build()
    }


}
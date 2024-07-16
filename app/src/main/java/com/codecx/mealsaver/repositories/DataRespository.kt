package com.codecx.mealsaver.repositories

import android.content.Context
import com.codecx.mealsaver.api.WebClient
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.dataclasses.MealDataClass
import com.example.pokemon.interfaces.ResultCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Objects

class DataRespository(private val context: Context, private val webClient: WebClient) {
    fun searchMeal(searchVar: String, resultCall: ResultCall<MealDataClass>) {
        webClient.api()?.searchMeal(searchVar)?.enqueue(object : Callback<MealDataClass> {
            override fun onResponse(
                call: Call<MealDataClass>,
                response: Response<MealDataClass>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {
                        if (result.meals?.isNotEmpty()==true) {
                            resultCall.resultSuccess(result)
                        } else {
                            resultCall.onFail("Data not found")
                        }
                    } else {
                        resultCall.onFail("Data not found")
                    }
                } else {
                    resultCall.onFail("Data not found")
                }
            }

            override fun onFailure(call: Call<MealDataClass>, t: Throwable) {
                resultCall.onFail(t.message ?: "")
            }

        })
    }


}
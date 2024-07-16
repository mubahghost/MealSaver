package com.codecx.mealsaver.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.dataclasses.MealDataClass
import com.codecx.mealsaver.db.DataBaseUtil
import com.codecx.mealsaver.repositories.DataRespository
import com.codecx.mealsaver.sealclasses.DataStates
import com.example.pokemon.interfaces.ResultCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel(
    private val dataBaseUtil: DataBaseUtil,
    private val dataRespository: DataRespository
) : ViewModel() {
    private val _meals: MutableStateFlow<DataStates> = MutableStateFlow(DataStates.Initial)
    val meals = _meals.asStateFlow()

    private val _searchMeals: MutableLiveData<List<Meal>> = MutableLiveData()
    val searchMeals :LiveData<List<Meal>> = _searchMeals
    fun addDataIntoDataBase(resultCall: ResultCall<String>) =
        viewModelScope.launch(Dispatchers.IO) {
            dataBaseUtil.addData(resultCall)
        }

    fun loadData(searchVar: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _meals.value = DataStates.Loading
            dataRespository.searchMeal(searchVar, object : ResultCall<MealDataClass>() {
                override fun resultSuccess(result: MealDataClass) {
                    super.resultSuccess(result)
                    _meals.value = DataStates.Success(result)
                }

                override fun onFail(message: String) {
                    super.onFail(message)
                    _meals.value = DataStates.Error(Exception(message))
                }
            })
        } catch (ex: java.lang.Exception) {
            _meals.value = DataStates.Error(ex)
        }
    }

    fun saveData(loadedData: MealDataClass, resultCall: ResultCall<String>)=viewModelScope.launch(Dispatchers.IO) {
        dataBaseUtil.addMeal(loadedData,resultCall)
    }

    fun loadMeals()=viewModelScope.launch {
        val result= withContext(Dispatchers.IO){dataBaseUtil.loadData()}
        _searchMeals.postValue(result)
    }


}
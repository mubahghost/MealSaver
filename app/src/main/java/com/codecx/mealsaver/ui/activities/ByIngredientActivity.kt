package com.codecx.mealsaver.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.codecx.mealsaver.R
import com.codecx.mealsaver.databinding.ActivityByIngredientBinding
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.dataclasses.MealDataClass
import com.codecx.mealsaver.sealclasses.DataStates
import com.codecx.mealsaver.utils.ProgressUtil
import com.codecx.mealsaver.viewmodels.MainViewModel
import com.example.pokemon.interfaces.ResultCall
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.StringBuilder

class ByIngredientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityByIngredientBinding
    private val mMainViewModel: MainViewModel by viewModel()
    private var mProgressUtil: ProgressUtil? = null
    private var loadedData: MealDataClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityByIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mProgressUtil = ProgressUtil(this)
        with(binding) {
            btnAddMeal.setOnClickListener {
                addDataIntoDataBase()
            }
            btnSearchMeal.setOnClickListener {
                val searchVar = txtSearch.editText?.text.toString()
                if (searchVar.isEmpty()) {
                    txtSearch.error = "Required..."
                } else {
                    mMainViewModel.loadData(searchVar)
                }
            }

        }
        lifecycleScope.launchWhenStarted {
            mMainViewModel.meals.collectLatest {
                when (it) {
                    is DataStates.Initial -> {}
                    is DataStates.Loading -> {
                        mProgressUtil?.showProgress("Searching for ${binding.txtSearch.editText?.text?.toString()}")
                    }
                    is DataStates.Error -> {
                        dismissProgress()
                        Toast.makeText(
                            this@ByIngredientActivity,
                            it.error.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is DataStates.Success<*> -> {
                        dismissProgress()
                        val value = it.result as MealDataClass
                        loadedData = value
                        bindData(value)
                    }
                }
            }
        }
    }

    private fun bindData(value: MealDataClass) {
        val sb:java.lang.StringBuilder = StringBuilder()
        value.meals?.forEach {
            sb.append(it.toString())
            sb.append("\n")
        }
        binding.tvInfo.text = sb.toString()
    }

    private fun dismissProgress() {
        mProgressUtil?.dismissDialog()
    }

    private fun addDataIntoDataBase() {
        if (loadedData == null) {
            Toast.makeText(this, "Data not found to save", Toast.LENGTH_SHORT).show()
        } else {
            mMainViewModel.saveData(loadedData!!, object : ResultCall<String>() {
                override fun onFail(message: String) {
                    super.onFail(message)
                    runOnUiThread {
                        Toast.makeText(this@ByIngredientActivity, message, Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun resultSuccess(result: String) {
                    super.resultSuccess(result)
                    runOnUiThread {
                        Toast.makeText(this@ByIngredientActivity, result, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
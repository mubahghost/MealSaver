package com.codecx.mealsaver.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codecx.mealsaver.R
import com.codecx.mealsaver.adaptors.DataAdaptor
import com.codecx.mealsaver.databinding.ActivityByIngredientBinding
import com.codecx.mealsaver.databinding.ActivityByMealBinding
import com.codecx.mealsaver.dataclasses.Meal
import com.codecx.mealsaver.dataclasses.MealDataClass
import com.codecx.mealsaver.sealclasses.DataStates
import com.codecx.mealsaver.utils.ProgressUtil
import com.codecx.mealsaver.viewmodels.MainViewModel
import com.example.pokemon.interfaces.ResultCall
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class ByMealActivity : AppCompatActivity() {
    private lateinit var binding: ActivityByMealBinding
    private val mMainViewModel: MainViewModel by viewModel()
    private var mAdaptor: DataAdaptor? = null
    private var mList: List<Meal>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityByMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            mMainViewModel.loadMeals()
        }
        initRecycler()
        with(binding) {
            btnSearchMeal.setOnClickListener {
                val searchVar = txtSearch.editText?.text.toString()
                if (searchVar.isEmpty()) {
                    txtSearch.error = "Required..."
                } else {
                    val filterData = mList?.filter {
                        it.strMeal?.contains(searchVar) == true || it.strIngredient1?.contains(
                            searchVar
                        ) == true
                    }
                    mAdaptor?.submitData(filterData ?: listOf())
                }
            }
            txtSearch.editText?.doOnTextChanged { text, start, before, count ->
                if (text?.isEmpty() == true) {
                    mAdaptor?.submitData(mList ?: listOf())
                }
            }

        }
        mMainViewModel.searchMeals.observe(this) {
            if (it.isEmpty()) {
                Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show()
            } else {
                mList = it
                mAdaptor?.submitData(it)
            }
        }
    }

    private fun initRecycler() {
        mAdaptor = DataAdaptor()
        binding.mDataList.apply {
            layoutManager =
                LinearLayoutManager(this@ByMealActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdaptor
        }
    }


}
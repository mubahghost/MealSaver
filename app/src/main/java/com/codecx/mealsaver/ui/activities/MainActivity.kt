package com.codecx.mealsaver.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codecx.mealsaver.R
import com.codecx.mealsaver.databinding.ActivityMainBinding
import com.codecx.mealsaver.viewmodels.MainViewModel
import com.example.pokemon.interfaces.ResultCall
import org.koin.android.ext.android.inject
//  https://youtu.be/RhOazltvPnA  <------  youtube link
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val mainViewModel:MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnAddMeal.setOnClickListener {
                mainViewModel.addDataIntoDataBase(object : ResultCall<String>() {
                    override fun onFail(message: String) {
                        super.onFail(message)
                        runOnUiThread {
                            Toast.makeText(this@MainActivity, "Fail to save", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    override fun resultSuccess(result: String) {
                        super.resultSuccess(result)
                        runOnUiThread{
                            Toast.makeText(this@MainActivity, "Save Successful", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
            btnByIngredient.setOnClickListener {
                startActivity(Intent(this@MainActivity,ByIngredientActivity::class.java))
            }
            btnByMeal.setOnClickListener {
                startActivity(Intent(this@MainActivity,ByMealActivity::class.java))

            }
        }
    }
}
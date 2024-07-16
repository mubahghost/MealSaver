package com.codecx.mealsaver.appclass

import android.app.Application
import com.codecx.mealsaver.api.WebClient
import com.codecx.mealsaver.db.DataBaseUtil
import com.codecx.mealsaver.repositories.DataRespository
import com.codecx.mealsaver.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ApplicationClass)
            modules(listOf(mainModule))
        }
    }

    private val mainModule = module {
        viewModel {
            MainViewModel(
                DataBaseUtil(androidContext()),
                DataRespository(androidContext(), WebClient(androidContext()))
            )
        }
    }
}
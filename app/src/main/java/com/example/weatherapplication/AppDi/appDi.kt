package com.example.weatherapplication.AppDi




import com.example.weatherapplication.CounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CounterViewModel() }
}
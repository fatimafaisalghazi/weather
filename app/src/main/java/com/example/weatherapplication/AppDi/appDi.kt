package com.example.weatherapplication.AppDi

import com.example.weatherapplication.ui.theme.Composable.ViewModeul.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { WeatherViewModel() }
    HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                    isLenient = true
                    encodeDefaults = true
                }
            )
        }
    }
}

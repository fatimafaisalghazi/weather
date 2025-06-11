package com.example.weatherapplication.Data.NetWork

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

class APIService {
//    private val BaseURL=""
//    private val httpClient = HttpClient {
//        install(ContentNegotiation) {
//            json(
//                Json {
//                    encodeDefaults = true
//                    isLenient = true
//                    coerceInputValues = true
//                    ignoreUnknownKeys = true
//                }
//            )
//        }


//    suspend fun getWeather(City:String):WeatherResponse{
//        return httpClient.get("$BaseURL $City& A")
//    }
}

suspend fun getWeatherByLocation() {
    val client = HttpClient(CIO)
    val respond =
        client.get("https://www.google.com/url?source=meet&sa=D&q=https%3A%2F%2Fapi.open-meteo.com%2Fv1%2Fforecast%3Flatitude%3D30.0626%26longitude%3D31.2497%26daily%3Dtemperature_2m_max%2Ctemperature_2m_min%2Cweather_code%2Cuv_index_max%26hourly%3Dtemperature_2m%2Cweather_code%2Cis_day%26current%3Dtemperature_2m%2Cwind_speed_10m%2Crelative_humidity_2m%2Crain%2Cweather_code%2Capparent_temperature%2Cpressure_msl%2Cis_day%2Cprecipitation&hl=en-US")
    println(respond)
}

fun main() {
    runBlocking {
        getWeatherByLocation()
    }
}
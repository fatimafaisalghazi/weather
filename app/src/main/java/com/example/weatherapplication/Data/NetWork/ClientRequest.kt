package com.example.weatherapplication.Data.NetWork

import com.example.weatherapplication.Data.DTO.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ClientRequest(private val client: HttpClient) {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse {
        return client.get (BASE_URL){
            parameter("latitude",latitude)
            parameter("longitude",longitude)
            parameter("daily","temperature_2m_max,temperature_2m_min")
            parameter("hourly","temperature_2m,weather_code")
            parameter("timezone","auto")
            parameter("current","is_day,apparent_temperature,relative_humidity_2m,temperature_2m,rain")
        }.body()
    }
   private companion object{
         const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
    }
}
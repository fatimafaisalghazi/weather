package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class HourlyWeatherDTO(
    @SerialName("temperature_2m")
    val temperature_2m: List<Double>? = null,
    @SerialName("time")
    val time: List<String>? = null,
    @SerialName("weather_code")
    val weather_code: List<Int>?=null
)
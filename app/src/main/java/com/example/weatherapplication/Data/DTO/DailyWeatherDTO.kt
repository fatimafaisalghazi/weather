package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherDTO(
    @SerialName("time")
    val time: List<String>? = null,
    @SerialName("temperature_2m_max")
    val temperature_2m_max: List<Int>? = null,
    @SerialName("temperature_2m_min")
    val temperature_2m_min: List<Int>? = null,
)

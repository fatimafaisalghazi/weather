package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDTO(
    @SerialName("time")
    val time: String? = null,
    @SerialName("interval")
    val interval: Int? = null,
    @SerialName("is_day")
    val is_day: Boolean? = null,
    @SerialName("apparent_temperature")
    val apparent_temperature: Double? = null,
    @SerialName("relative_humidity_2m")
    val relative_humidity_2m: Int? = null,
    @SerialName("temperature_2m")
    val temperature_2m: Int? = null,
    @SerialName("rain")
    val rain: Int? = null
)
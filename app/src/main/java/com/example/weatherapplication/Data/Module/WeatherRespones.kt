package com.example.weatherapplication.Data.Module

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val latiude: Double,
    val longitude: Double,
    @SerialName("generationtime_ms") val generation: Double,
    val temperature: Double,
    val precipitation: Double,
    val windSpeed: Double,
    val humidity: Double,
    val uvIndex: Double?
) {}


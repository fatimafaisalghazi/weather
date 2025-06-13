package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.Serializable

@Serializable

data class Hourly(
    val relative_humidity_2m: List<Int>? = null,
    val temperature_2m: List<Double>? = null,
    val time: List<String>? = null,
    val wind_speed_10m: List<Double>? = null
)
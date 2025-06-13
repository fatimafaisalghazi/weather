package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.Serializable

@Serializable

data class HourlyUnits(
    val relative_humidity_2m: String? = null,
    val temperature_2m: String? = null,
    val time: String? = null,
    val wind_speed_10m: String? = null
)
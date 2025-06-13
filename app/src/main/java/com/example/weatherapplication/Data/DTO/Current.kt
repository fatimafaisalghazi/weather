package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.Serializable

@Serializable

data class Current(
    val interval: Int? = null,
    val temperature_2m: Double? = null,
    val time: String? = null,
    val wind_speed_10m: Double? = null
)
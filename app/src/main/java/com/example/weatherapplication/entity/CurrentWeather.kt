package com.example.weatherapplication.entity


data class CurrentWeather(
    val time: String? = null,
    val interval: Int? = null,
    val is_day: Boolean? = null,
    val apparent_temperature: Double? = null,
    val relative_humidity_2m: Int? = null,
    val temperature_2m: Int? = null,
    val rain: Int?=null
)
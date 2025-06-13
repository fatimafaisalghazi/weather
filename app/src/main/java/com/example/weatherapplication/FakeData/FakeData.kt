package com.example.weatherapplication.FakeData

data class WeatherInfo(
    val measurement: String,
    val description: String,
    val iconResId: Int
)

data class WeatherFake(
    val condition: Weather.Condition,
    val temperature: Weather.Temperature,
    val maxTemperature: Weather.Temperature,
    val minTemperature: Weather.Temperature
)
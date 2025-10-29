package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("latitude")
    val latitude: Double?=null,
    @SerialName("longitude")
    val longitude: Double?=null,
    @SerialName("timezone")
    val timezone: String?=null,
    @SerialName("elevation")
    val elevation: Int?=null,
    @SerialName("current")
    val current: CurrentWeatherDTO?=null,
    @SerialName("hourly")
    val hourly: HourlyWeatherDTO?=null,
    @SerialName("daily")
    val dailyWeatherDTO:DailyWeatherDTO?=null
)
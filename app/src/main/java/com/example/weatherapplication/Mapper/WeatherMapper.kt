package com.example.weatherapplication.Mapper

import com.example.weatherapplication.Data.DTO.CurrentWeatherDTO
import com.example.weatherapplication.entity.CurrentWeather

fun CurrentWeatherDTO.toEntity(): CurrentWeather{
    return CurrentWeather(
        time = time.orEmpty(),
        interval = interval?: 0,
        is_day = is_day?: false,
        apparent_temperature = apparent_temperature ?: 0.0,
        relative_humidity_2m = relative_humidity_2m?: 0,
        temperature_2m = temperature_2m?: 0,
        rain = rain ?: 0
    )
}
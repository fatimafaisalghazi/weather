package com.example.weatherapplication.Data.DTO

import kotlinx.serialization.Serializable

@Serializable

data class weatherByLocationDTO(
    val elevation: Int? = null,
    val generationtime_ms: Double? = null,
    val hourly: Hourly? = null,
    val hourly_units: HourlyUnits? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val timezone: String? = null,
    val timezone_abbreviation: String? = null,
    val utc_offset_seconds: Int? = null
)
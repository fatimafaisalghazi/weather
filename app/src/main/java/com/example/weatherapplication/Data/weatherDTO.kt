package com.example.weatherapplication.Data

data class weatherDTO(
    val latitude: Float? = null,
    val longitude: Float? = null,
    val elevation: Float? = null,
    val generationtime_ms: Float? = null,
    val utc_offset_seconds: Int? = null,
    val timezone: String? = null,
    val timezone_abbreviation: String? = null,
    val hourly: Hourly = Hourly(),
    val hourly_units:Hourly_units?=null
) {
    data class Hourly(
        val time: String? = null,
        val temperature_2m: List<Float?> = emptyList()
    )
    enum class Hourly_units(val unit:String)
    {
        temperature_2m ("°C")
    }
}

//{
//    "latitude": 52.52,
//    "longitude": 13.419,
//    "elevation": 44.812,
//    "generationtime_ms": 2.2119,
//    "utc_offset_seconds": 0,
//    "timezone": "Europe/Berlin",
//    "timezone_abbreviation": "CEST",
//    "hourly": {
//    "time": ["2022-07-01T00:00", "2022-07-01T01:00", "2022-07-01T02:00", ...],
//    "temperature_2m": [13, 12.7, 12.7, 12.5, 12.5, 12.8, 13, 12.9, 13.3, ...]
//},
//    "hourly_units": {
//    "temperature_2m": "°C"
//}
//}
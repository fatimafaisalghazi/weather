package com.example.weatherapplication.Data.NetWork

import com.example.weatherapplication.Data.DTO.weatherByLocationDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ClientRequest(private val client: HttpClient) {
    suspend fun getWeather(latitude: Double, longitude: Double): weatherByLocationDTO
    {
        return client.get (baseURL){
            "https://api.open-meteo.com/2Fv1/2Fforecast/3Flatitude/3D30.0626/26longitude/3D31.2497/26daily/3Dtemperature_2m_max/2Ctemperature_2m_min/2Cweather_code/2Cuv_index_max/26hourly/3Dtemperature_2m/Cweather_code/2Cis_day/26current/Dtemperature_2m/2Cwind_speed_10m/2Crelative_humidity_2m/2Crain/2Cweather_code/2Capparent_temperature/2Cpressure_msl/2Cis_day/Cprecipitation&hl=en-US"

            parameter("latitude",latitude)
            parameter("longitude",longitude)
            parameter("daily","temperature_2m_max,temperature_2m_min,weather_code,uv_index_max")
            parameter("hourly","temperature_2m,weather_code,is_day")
            parameter(
                "current","temperature_2m/2Cwind_speed_10m/2Crelative_humidity_2m/2Crain/2Cweather_code/2Capparent_temperature/2Cpressure_msl/2Cis_day")



        }.body()
    }
    companion object{
        const val baseURL="https://api.open-meteo.com/2Fv1/2Fforecast"
    }
}
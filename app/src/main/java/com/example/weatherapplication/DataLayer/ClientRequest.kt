package com.example.weatherapplication.DataLayer

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ClientRequest(private val client: HttpClient) {
    suspend fun getWeather(latitude: Double, longitude: Double) //weathetDTO
    {//return
        client.get (baseURL){
            "https://api.open-meteo.com/2Fv1/2Fforecast/3Flatitude/3D30.0626/26longitude/3D31.2497/26daily/3Dtemperature_2m_max/2Ctemperature_2m_min/2Cweather_code/2Cuv_index_max/26hourly/3Dtemperature_2m/Cweather_code/2Cis_day/26current/Dtemperature_2m/2Cwind_speed_10m/2Crelative_humidity_2m/2Crain/2Cweather_code/2Capparent_temperature/2Cpressure_msl/2Cis_day/Cprecipitation&hl=en-US"

            parameter("latitude",latitude)
            parameter("longitude",longitude)


        }
    }
    companion object{
        const val baseURL="https://api.open-meteo.com/2Fv1/2Fforecast"
    }
}
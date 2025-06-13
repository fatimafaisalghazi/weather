//package com.example.weatherapplication.Mapper
//
//import com.example.weatherapplication.Data.Module.WeatherDto
//import com.example.weatherapplication.exception.DataError
//import com.example.weatherapplication.exception.NetWorkError
//
//class WeatherMapper {
//   private val mapper= jacksonObjectMapper()
//
//   fun toEntity(jsonString: String): WeatherDto {
//      val json = try {
//         mapper.readTree(jsonString)
//      }catch (e:Exception){
//         throw NetWorkError(" failed to parse {${e.message}}")
//      }
//      val current =json.get("current")?: throw DataError("unavaible")
//      return WeatherDto(
//          latiude = TODO(),
//          longitude = TODO(),
//          generation = TODO(),
//          temperature = TODO(),
//          precipitation = TODO(),
//          windSpeed = TODO(),
//          humidity = TODO(),
//          uvIndex = TODO()
//      )
//
//   }
//}
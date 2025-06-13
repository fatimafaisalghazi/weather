package com.example.weatherapplication.ui.theme.Composable

import HourlyWeatherCard
import HourlyWeatherCardData
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.R


@Composable
fun HourlyScrren() {
    val TodayForcastInfo = listOf(
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "11:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "12:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "1:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "2:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "3:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "4:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "5:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "6:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "7:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "8:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "9:00"),
        HourlyWeatherCardData(icon = R.drawable.clearsky1, temper = "25 °C", hour = "10:00")
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(TodayForcastInfo) { item ->
            HourlyWeatherCard(
                Icon = item.icon,
                hour = item.hour,
                temper = item.temper
            )
        }
    }
}
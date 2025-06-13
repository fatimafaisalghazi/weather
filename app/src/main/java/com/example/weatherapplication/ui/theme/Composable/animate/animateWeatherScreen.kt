package com.example.weatherapplication.ui.theme.Composable.animate

import HourlyWeatherCard
import HourlyWeatherCardData
import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.FakeData.WeatherFake
import com.example.weatherapplication.FakeData.WeatherInfo
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.Composable.CurrentWeatherHeader
import com.example.weatherapplication.ui.theme.Composable.DailyContentView
import com.example.weatherapplication.ui.theme.Composable.HourlyScrren
import com.example.weatherapplication.ui.theme.Composable.weatherDescCard
import com.example.weatherapplication.ui.theme.SecondryBlack
import com.example.weatherapplication.ui.theme.background
import com.example.weatherapplication.ui.theme.background2


@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun animateWeatherScreen() {
    val fakeWeather = WeatherFake(
        condition = Weather.Condition.Clear,
        temperature = Weather.Temperature(24, "°C"),
        maxTemperature = Weather.Temperature(32, "°C"),
        minTemperature = Weather.Temperature(20, "°C")
    )

    val fakeCityName = "Amarah"
    val fakeIsDay = true
    val listState = rememberLazyListState()
    val isCollapsed by derivedStateOf {
        listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 0
    }
    val weatherItems = listOf(
        WeatherInfo("12 KM/h", "Wind", R.drawable.fastwind),
        WeatherInfo("70%", "Humidity", R.drawable.content),
        WeatherInfo("2%", "Rain", R.drawable.rain),
        WeatherInfo("2", "UV Index", R.drawable.uv),
        WeatherInfo("1013 hPa", "Pressure", R.drawable.prasseur),
        WeatherInfo("22 °C", "Feels Like", R.drawable.temperature)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(background, background2)
                )
            )
    ) {

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CurrentWeatherHeader(
                    isCollapsed = isCollapsed,
                    cityName = fakeCityName,
                    weatherCondition = fakeWeather.condition,
                    currentTemperature = fakeWeather.temperature,
                    maxTemperature = fakeWeather.maxTemperature,
                    minTemperature = fakeWeather.minTemperature,
                    isDay = fakeIsDay
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp)) // Add vertical spacing
            }


            item {

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                    //  ),
                    , horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    weatherItems.forEach { item ->
                        weatherDescCard(
                            weatherMeasurement = item.measurement,
                            titleDecripedBy = item.description,
                            Icon = item.iconResId,
                            modifier = Modifier.weight(1f)
                        )

                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = "Today",
                        fontSize = 20.sp,
                        fontWeight = FontWeight((600)),
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }
            item { HourlyScrren() }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = "Next 7 days",
                        fontSize = 20.sp,
                        fontWeight = FontWeight((600)),
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = SecondryBlack,
                            shape = RoundedCornerShape(24.dp)
                        )
                    //.padding(horizontal = 16.dp)
                    ,

                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(Modifier.height(13.dp))
                        DailyContentView(
                            day = "Monday", modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Tuesday",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Wednesday",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Thursday",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Friday",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Saturday",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))

                        Divider()
                        Spacer(Modifier.height(13.dp))

                        DailyContentView(
                            day = "Sunday",
                            ImageofWeather = R.drawable.mainlyclear1,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(Modifier.height(13.dp))


                    }
                }
            }

        }
    }
}
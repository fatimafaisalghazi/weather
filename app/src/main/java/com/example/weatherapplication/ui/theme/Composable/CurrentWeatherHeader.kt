package com.example.weatherapplication.ui.theme.Composable

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.ui.theme.SecondryBlack
import com.example.weatherapplication.ui.theme.blurColor
import com.example.weatherapplication.ui.theme.citycol
import com.example.weatherapplication.ui.theme.minAndMaxBackGround


@Composable
fun CurrentWeatherHeader(
    modifier: Modifier = Modifier,
    isCollapsed: Boolean,
    cityName: String,
    weatherCondition: Weather.Condition,
    currentTemperature: Weather.Temperature,
    maxTemperature: Weather.Temperature,
    minTemperature: Weather.Temperature,
    isDay: Boolean
) {

    val transition = updateTransition(targetState = isCollapsed, label = "HeaderTransition")

    // Animated values for image size and position
    val imageSize by transition.animateDp(label = "ImageSize", transitionSpec = { tween(800) }
    ) {
        if (it) 120.dp else 200.dp
    }

    val imageOffsetX by transition.animateDp(
        label = "ImageOffsetX",
        transitionSpec = { tween(800) }) {
        if (it) (-125).dp else 0.dp
    }
    val imageOffsety by transition.animateDp(
        label = "ImageOffsety",
        transitionSpec = { tween(800) }) {
        if (it) (180).dp else 0.dp
    }

    val contentOffsetX by transition.animateDp(
        label = "ContentOffsetX",
        transitionSpec = { tween(800) }) {
        if (it) 90.dp else 0.dp
    }

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Spacer(Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    painter = painterResource(R.drawable.icon__4_), contentDescription = null,
                    tint = citycol
                )
                //   Spacer(Modifier.height(8.dp))
                Text(
                    cityName, fontWeight = FontWeight(500),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = citycol
                )
            }
            // Image Box (top or left)
            Box(
                modifier = Modifier
                    .offset(x = imageOffsetX, y = imageOffsety), contentAlignment = Alignment.Center
            ) {
                //Spacer(Modifier.height(8.dp))
                Blurrey(
                    size = 250.dp,
                    color = blurColor,
                )
                Image(
                    painter = painterResource(id = R.drawable.clearsky1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSize)
                )

            }

            Box(
                modifier = Modifier
                    .offset(x = contentOffsetX)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "${currentTemperature.value}${currentTemperature.unit}",
                        fontSize = 64.sp,
                        fontWeight = FontWeight((500)),
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(
                        text = when (weatherCondition) {
                            Weather.Condition.Clear -> "Clear Sky"
                            Weather.Condition.Cloudy -> "Partly Cloudy"
                            Weather.Condition.Rain -> "Rain"
                            Weather.Condition.Snow -> "Snow"
                            Weather.Condition.Thunderstorm -> "Thunderstorm"
                        },
                        fontSize = 16.sp,
                        fontWeight = FontWeight((500)),
                        fontFamily = FontFamily.SansSerif,
                        color = SecondryBlack
                    )
                    Box(
                        modifier = Modifier
                            .height(35.dp)
                            .width(168.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .background(minAndMaxBackGround),
                        contentAlignment = Alignment.Center
                    ) {
                        Spacer(Modifier.height(16.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.icon__5_),
                                contentDescription = null, tint = citycol
                            )
                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = "${maxTemperature.value}°C",
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                color = citycol
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                painter = painterResource(R.drawable.line_1),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(R.drawable.icon__6_),
                                contentDescription = null, tint = citycol
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${minTemperature.value}°C",
                                fontWeight = FontWeight(500),
                                fontSize = 16.sp,
                                color = citycol
                            )
                        }
                    }
                }
            }
        }
    }
}
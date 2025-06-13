package com.example.weatherapplication.ui.theme.Composable

import android.health.connect.datatypes.units.Temperature
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        LocationDisplyer(LocationIcon = R.drawable.icon__4_, CityName = "Amarah")//stick
        WeatherCondionByImage(ConditionIcon = R.drawable.clearsky1)//move
        DescripeWeatherCondition(temperatureInCeleluis = "24 C","Partly Cloudy","32 C","20 C")//move
    }
}

@Composable
fun LocationDisplyer(
    LocationIcon: Int,
    CityName: String
) {
    Box(contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(painter = painterResource(LocationIcon), contentDescription = null)
            Spacer(Modifier.width(4.dp))
            Text(
                CityName, fontWeight = FontWeight(500),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}


@Composable
fun WeatherCondionByImage(
    modifier: Modifier = Modifier,
    ConditionIcon: Int
) {
    Spacer(modifier = Modifier.height(14.dp))
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(ConditionIcon), contentDescription = null,
            modifier = modifier.size(200.dp)
        )
    }
}

@Composable
fun DescripeWeatherCondition(
    temperatureInCeleluis: String,
    ConditionStr: String,
    UpperTemp: String,
    LowerTemp: String
) {
    Box(contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                temperatureInCeleluis, fontWeight = FontWeight(600),
                fontSize = 64.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    ConditionStr, fontWeight = FontWeight(500),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            Box(
                Modifier
                    .height(35.dp)
                    .width(168.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0x06041414)), contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(R.drawable.icon__5_),
                        contentDescription = null, Modifier
                            .width(4.dp)
                            .height(8.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        UpperTemp, fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,

                        )
                    //Divider()
                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(R.drawable.line_1),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        painter = painterResource(R.drawable.icon__6_),
                        contentDescription = null, Modifier
                            .width(4.dp)
                            .height(8.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        LowerTemp, fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                    )

                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun hederPeevie() {
    ScreenContent()
}
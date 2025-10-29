package com.example.weatherapplication.ui.theme.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.ui.theme.SecondryBlack

@Composable
fun weatherDescCard(
    weatherMeasurement:String,
    titleDecripedBy:String,
    Icon:Int,
    modifier: Modifier=Modifier
) {
    Box(
        modifier = modifier.width(108.dp)
            .border(
                width = 1.dp,
                color = SecondryBlack,
                shape = RoundedCornerShape(24.dp)
            ).background(
                Color.White,
                shape = RoundedCornerShape(24.dp)
            ).padding(vertical = 16.dp, horizontal = 8.dp)


        , contentAlignment = Alignment.Center


    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(Icon), contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                weatherMeasurement, fontWeight = FontWeight(500),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                titleDecripedBy, fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = SecondryBlack,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun preniyy() {
//   weatherDescCard()
}
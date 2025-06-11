package com.example.weatherapplication.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.weatherapplication.R


@Composable
fun TodayDesc() {
    Box(
        modifier = Modifier
            .height(120.dp)
            .width(88.dp)

            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20)
            ).background(
                Color.White,
                shape = RoundedCornerShape(12.dp)
            )

        , contentAlignment = Alignment.TopCenter


    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Box(
                modifier = Modifier
                    .zIndex(1f)
                    .offset(y = -20.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.clearsky1),
                    contentDescription = null,
                    modifier = Modifier.size(58.dp)
                )
            }


            Text(
                "12 %", fontWeight = FontWeight(500),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )
            //  Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Rain", fontWeight = FontWeight(400),
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun pertxzjni() {
    TodayDesc()
}
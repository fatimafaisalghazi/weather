package com.example.weatherapplication.Composable

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
fun HeaderApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        item1()
        Item2(Modifier)
        Item3()
    }
}

@Composable
fun item1() {


    Box(contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(painter = painterResource(R.drawable.icon__4_), contentDescription = null)
            Spacer(Modifier.width(4.dp))
            Text(
                "Baghdad", fontWeight = FontWeight(500),
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
//24°C
            )
        }
    }
}


@Composable
fun Item2(modifier: Modifier) {
    Spacer(modifier = Modifier.height(14.dp))
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.mainlyclear1), contentDescription = null,
            modifier = modifier.size(200.dp)
        )
    }
}

@Composable
fun Item3() {
    Box(contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "24°C\n", fontWeight = FontWeight(600),
                fontSize = 64.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
            )//Partly cloudy
            Row(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Partly cloudy", fontWeight = FontWeight(500),
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
                        "35 C", fontWeight = FontWeight(500),
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
                        "20 C", fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = Color.Black,
                    )

                }
            }
        }
    }
    //
}

@Composable
fun Item4() {

}

@Preview(showBackground = true)
@Composable
fun hederPeevie() {
    HeaderApp()
}
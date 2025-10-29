package com.example.weatherapplication.ui.theme.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import com.example.weatherapplication.R

@Composable
fun DailyContentView(
    day: String,
    modifier: Modifier = Modifier,
    weatherImage: Int = R.drawable.clearsky1
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = day,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
            modifier = Modifier.weight(0.3f)
        )

        Image(
            painter = painterResource(weatherImage),
            contentDescription = "weatherImage",
            Modifier.size(36.dp).weight(0.2f)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(0.5f)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon__5_),
                contentDescription = "arrow up", tint = Color.Black
            )

            Text(
                text = "32 °C",
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                color = Color.Black
            )
            Icon(
                painter = painterResource(R.drawable.line_1),
                contentDescription = "line"
            )
            Icon(
                painter = painterResource(R.drawable.icon__6_),
                contentDescription = "arrow down", tint = Color.Black
            )

            Text(
                text = "23 °C",
                fontWeight = FontWeight(500),
                fontSize = 16.sp,
                color = Color.Black
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun fvegdbnsj() {
    DailyContentView("mon")
}
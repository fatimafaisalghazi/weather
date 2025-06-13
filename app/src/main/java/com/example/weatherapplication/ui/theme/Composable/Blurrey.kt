package com.example.weatherapplication.ui.theme.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Blurrey(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color,
    opacity: Float = 0.22f,
    blurRadius: Dp = 150.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        color.copy(alpha = opacity),
                        color.copy(alpha = opacity * 0.7f),
                        color.copy(alpha = opacity * 0.01f)
                    )
                )
            )
            .blur(radius = blurRadius)
    )
}

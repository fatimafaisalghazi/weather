package com.example.weatherapplication.ui.theme.AppTheme

import androidx.compose.ui.graphics.Color

val LightColors = ColorScheme(
    primary = Color(0xFF6200EE),
    CityName =Color(0xFF323232),/////////////////////////
    primaryContainer = Color(0xFFEADDFF),
    onPrimaryContainer = Color.Black,
    background = Color(0xFF87CEFA),/////////////////
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color.Red,
    onError = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black
)

val DarkColors = ColorScheme(
    primary = Color(0xFFBB86FC),
    CityName =Color(0x323232),
    primaryContainer = Color(0xFF3700B3),
    onPrimaryContainer = Color.White,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black
)
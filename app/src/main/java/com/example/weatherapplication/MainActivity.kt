package com.example.weatherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import com.example.weatherapplication.ui.theme.Composable.animate.animateWeatherScreen
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherApplicationTheme {

                animateWeatherScreen()
                // HomeScreen()
            }
        }
    }
}


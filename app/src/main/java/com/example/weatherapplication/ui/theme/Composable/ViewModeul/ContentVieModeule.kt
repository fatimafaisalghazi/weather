package com.example.weatherapplication.ui.theme.Composable.ViewModeul

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class WeatherViewModel : ViewModel() {

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()
    
}
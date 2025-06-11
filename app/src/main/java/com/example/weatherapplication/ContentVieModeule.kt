package com.example.weatherapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CounterViewModel : ViewModel() {

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun onInceasCounter() {
        _state.update { it + 1 }
    }

    fun ondeceasCounter() {
        _state.update { it - 1 }
    }
}
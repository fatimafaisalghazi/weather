package com.example.weatherapplication.Presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun GetCurrentLocationScreen(viewModel: MyViewModel = viewModel()) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.getLocation(context, lifecycleOwner)
    }

    when (val state = viewModel.uiState.collectAsState().value) {
        is UiState.Loading -> {
            Text("جارٍ الحصول على الموقع...")
        }
        is UiState.Success -> {
            Text("الموقع الحالي: ${state.address}")
        }
        is UiState.Error -> {
            Text("خطأ: ${state.message}")
        }
    }
}
package com.example.weatherapplication.Composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedList() {
    val listState = rememberLazyListState()
    val items = List(20) { "Item $it" }
    var previousIndex by remember { mutableStateOf(0) }

    LaunchedEffect(listState.firstVisibleItemIndex) {
        if (listState.firstVisibleItemIndex != previousIndex) {
            previousIndex = listState.firstVisibleItemIndex
        }
    }

    LazyColumn(state = listState) {
        items(items = items, key = { it }) { item ->
            val isVisible = listState.firstVisibleItemIndex <= items.indexOf(item)
            val alpha by animateFloatAsState(targetValue = if (isVisible) 1f else 0.5f, label = "")
            val scale by animateFloatAsState(targetValue = if (isVisible) 1f else 0.8f, label = "")

            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(alpha = alpha, scaleX = scale, scaleY = scale)
                ) {
                    Text(text = item)
                }
            }
        }
    }
}

@Composable
fun ScrollTransformList() {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        items(20) { index ->
            val scrollOffset = remember { derivedStateOf {
                val layoutInfo = listState.layoutInfo
                val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index }
                itemInfo?.let {
                    it.offset.toFloat()
                } ?: 0f
            } }
            Box(modifier = Modifier
                .height(100.dp)
                .graphicsLayer {
                    translationY = (scrollOffset.value * 0.5f)
                }
            ) {
                TodayDesc()

                // Your item content
            }
        }
    }
}
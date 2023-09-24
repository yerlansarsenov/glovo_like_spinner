package com.borred.spinner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@Composable
internal fun SpinnerItem(
    modifier: Modifier = Modifier
) {
    val color = rememberRandomColor()
    Box(
        modifier = modifier
            .clip(CircleShape)
            .drawBehind {
                drawCircle(color = color)
            }
    )
}

@Composable
private fun rememberRandomColor(): Color {
    return remember {
        Color(
            red = Random.nextInt(from = 0, until = 0x100),
            green = Random.nextInt(from = 0, until = 0x100),
            blue = Random.nextInt(from = 0, until = 0x100)
        )
    }
}

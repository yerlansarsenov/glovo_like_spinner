package com.borred.spinner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
internal fun SpinnerItem(
    index: Int,
    modifier: Modifier = Modifier
) {
    val color = rememberRandomColor()
    Box(
        modifier = modifier
            .clip(CircleShape)
            .drawBehind {
                drawCircle(color = color)
            }
    ) {
        Text(
            text = "$index",
            color = if (color == Color.Black) {
                Color.White
            } else {
                Color.Black
            },
            modifier = Modifier.align(Alignment.Center)
        )
    }
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

@Preview
@Composable
private fun SpinnerItem_Preview() {
    SpinnerItem(
        index = 1,
        modifier = Modifier.size(50.dp)
    )
}

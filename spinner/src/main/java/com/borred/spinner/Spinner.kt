package com.borred.spinner

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun Spinner(
    count: Int,
    itemSize: Dp,
    modifier: Modifier = Modifier
) {
    Layout(
        modifier = modifier,
        content = {
            repeat(count) {
                SpinnerItem(
                    index = it,
                    color = Color.Black,
                    modifier = Modifier.size(itemSize)
                )
            }
        }
    ) { measurables, constraints ->
        val minSide = minOf(constraints.maxWidth, constraints.maxHeight)
        layout(width = minSide, height = minSide) {
            val halfItemSizePx = (itemSize / 2).roundToPx()
            val radius = minSide / 2 - halfItemSizePx
            val itemConstraints = constraints.copy(
                minWidth = 0,
                maxWidth = minSide,
                minHeight = 0,
                maxHeight = minSide
            )
            // if there is single item, then place it in center
            if (measurables.size == 1) {
                measurables.single()
                    .measure(constraints = itemConstraints)
                    .place(x = radius, y = radius)
                return@layout
            }
            val angles = (measurables.indices).map { index ->
                val degree = index * (360 / measurables.size)
                degree.toRadian()
            }
            for (i in measurables.indices) {
                val angle = angles[i]
                val x = radius * (1 + cos(angle))
                val y = radius * (1 + sin(angle))
                measurables[i]
                    .measure(itemConstraints)
                    .place(x = x.roundToInt(), y = y.roundToInt())
            }
            // otherwise calculate positions
        }
    }
}

private fun Int.toRadian(): Double = this / 180f * PI

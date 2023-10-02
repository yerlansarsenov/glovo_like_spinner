package com.borred.spinner

import android.util.Log
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.verticalDrag
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.isActive
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
    var angleDiffInDegree by remember {
        mutableStateOf(value = 0)
    }
    Layout(
        modifier = modifier.pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                val verticalDragOffset = change.positionChange().y
                angleDiffInDegree += verticalDragOffset.roundToInt()
                Log.e("HERE!!", "Spinner: verticalDragOffset = $verticalDragOffset")
            }
        },
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
                val degree = index * (360 / measurables.size) + angleDiffInDegree
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

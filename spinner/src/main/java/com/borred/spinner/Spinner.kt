package com.borred.spinner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
                    modifier = Modifier.size(itemSize)
                )
            }
        }
    ) { measurables, constraints ->
        val minSide = minOf(constraints.maxWidth, constraints.maxHeight)
        layout(width = minSide, height = minSide) {
            // if there is single item, then place it in center
            if (measurables.size == 1) {
                val halfItemSizePx = (itemSize / 2).roundToPx()
                measurables.single().measure(
                    constraints.copy(
                        minWidth = 0,
                        maxWidth = minSide,
                        minHeight = 0,
                        maxHeight = minSide
                    )
                ).place(
                    x = minSide / 2 - halfItemSizePx,
                    y = minSide / 2 - halfItemSizePx
                )
                return@layout
            }

            // otherwise calculate positions
        }
    }
}

@Preview
@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun Spinner_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 1,
        itemSize = 50.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

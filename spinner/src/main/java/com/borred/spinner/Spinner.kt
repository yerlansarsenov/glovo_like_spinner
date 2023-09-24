package com.borred.spinner

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp

@Composable
fun Spinner(
    count: Int,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Layout(
        modifier = modifier,
        content = {
            repeat(count) {
                SpinnerItem(modifier = Modifier.size(size))
            }
        }
    ) { measurables, constraints ->
        layout(width = constraints.maxWidth, height = constraints.maxHeight) {

        }
    }
}

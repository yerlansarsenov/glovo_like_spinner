package com.borred.spinner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "single item")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "single item horizontal")
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

@Preview(name = "two items")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "two items horizontal")
@Composable
private fun Spinner2_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 2,
        itemSize = 50.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

@Preview(name = "three items")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "three items horizontal")
@Composable
private fun Spinner3_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 3,
        itemSize = 150.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

@Preview(name = "four items")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "four items horizontal")
@Composable
private fun Spinner4_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 4,
        itemSize = 50.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

@Preview(name = "five items")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "five items horizontal")
@Composable
private fun Spinner5_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 5,
        itemSize = 50.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

@Preview(name = "many items")
@Preview(device = "spec:parent=pixel_5,orientation=landscape", name = "many items horizontal")
@Composable
private fun SpinnerMany_Preview(
    modifier: Modifier = Modifier
) {
    Spinner(
        count = 30,
        itemSize = 50.dp,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    )
}

package com.borred.glovo_like_spinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import com.borred.glovo_like_spinner.ui.theme.Glovo_like_spinnerTheme
import com.borred.spinner.Spinner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Glovo_like_spinnerTheme {
                // A surface container using the 'background' color from the theme
                Spinner(
                    count = 6,
                    itemSize = 50.dp
                )
            }
        }
    }
}

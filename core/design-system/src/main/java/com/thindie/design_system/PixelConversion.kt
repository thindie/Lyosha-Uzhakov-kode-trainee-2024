package com.thindie.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun convertPixelsToDp(pixels: Float, density: Density): Dp {
    val dpValue = with(density) {
        pixels.toDp()
    }
    return dpValue
}

@Composable
fun convertPixelsToSp(pixels: Float, density: Density): TextUnit {
    val spValue = with(density) {
        pixels.toSp()
    }
    return spValue
}
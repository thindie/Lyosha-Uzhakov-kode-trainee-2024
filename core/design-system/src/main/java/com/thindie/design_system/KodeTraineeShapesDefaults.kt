package com.thindie.design_system

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

//due minimum shape variants its hardcoded
object KodeTraineeShapesDefaults {

    private var isAdjusted = false

    private const val cornerRoundPx = 10f

    private var cornerRadius = 10.dp

    val searchBar by lazy { RoundedCornerShape(cornerRadius) }

    val bottomSheet by lazy { RoundedCornerShape(
        topStart = cornerRadius,
        topEnd = cornerRadius,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    ) }

    val avatar by lazy { CircleShape }

    val snackBar by lazy { searchBar }

    @Composable
    fun adjustShapes(density: Density) {
        if (isAdjusted.not()){
            cornerRadius = convertPixelsToDp(pixels = cornerRoundPx, density = density)
            isAdjusted  = true
        }

    }
    // Material theme Variant
    @Composable
    fun getMaterailShapes(density: Density): Shapes{
        adjustShapes(density =density)
        return Shapes( medium = searchBar, large = bottomSheet, extraLarge = avatar)
    }

}

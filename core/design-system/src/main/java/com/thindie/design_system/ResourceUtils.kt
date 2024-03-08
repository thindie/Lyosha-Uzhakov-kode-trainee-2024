package com.thindie.design_system

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


@Composable
fun @receiver:DrawableRes Int.painter(): Painter = painterResource(id = this)

@Composable
fun ImageVector.painter(): Painter = rememberVectorPainter(image = this)

@Composable
fun @receiver:StringRes Int.string(): String = stringResource(id = this)

@Composable
fun @receiver:ColorRes Int.color(): Color {
    return Color(this)
}
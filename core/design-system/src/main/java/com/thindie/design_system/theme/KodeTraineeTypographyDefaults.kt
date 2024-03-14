package com.thindie.design_system.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.thindie.design_system.R

object KodeTraineeTypographyDefaults {


    val labelSmall = 13.sp


    val labelSmallLineHeight = 16.sp


    val labelMedium = 14.sp

    val labelMediumLineHeight = 18.sp


    val bodySmall = 15.sp

    val bodySmallLineHeight = 20.sp


    val bodyMedium = 16.sp


    val bodyMediumLineHeight = 20.sp


    val titleSmall = 17.sp


    val titleSmallLineHeight = 22.sp


    val titleMedium = 20.sp

    val titleMediumLineHeight = 24.sp


    val titleLarge = 24.sp

    val titleLargeLineHeight = 28.sp


    private val labelFont = Font(R.font.inter)
    val labelFamily = labelFont.toFontFamily()

    private val bodyFont = Font(R.font.inter)
    val bodyFamily = bodyFont.toFontFamily()

    private val titleFont = Font(R.font.inter)
    val titleFamily = titleFont.toFontFamily()

    private val headLineFont = Font(R.font.inter)
    val headLineFamily = headLineFont.toFontFamily()

    private val displayFont = Font(R.font.inter)
    val displayFamily = displayFont.toFontFamily()

}
package com.thindie.design_system.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.thindie.design_system.R
import com.thindie.design_system.convertPixelsToSp

object KodeTraineeTypographyDefaults {

    private var isAdjusted = false

    private const val title1Px = 24f //titleLarge
    private const val title2Px = 20f //titleMedium
    private const val title3Px = 17f // titleSmall
    private const val headlinePx = 16f //bodyMedium
    private const val textPx = 15f //bodySmall
    private const val subHeadPx = 14f //labelMedium
    private const val captionPx = 13f  //labelSmall


    var labelSmall = 13.sp
        private set
    var labelMedium = 14.sp
        private set
    var bodySmall = 15.sp
        private set
    var bodyMedium = 16.sp
        private set

    var titleSmall = 17.sp
        private set

    var titleMedium = 20.sp
        private set

    var titleLarge = 24.sp
        private set


    private val labelFont = Font(R.font.inter)
    val labelFamily = labelFont.toFontFamily()

    private val bodyFont = Font(R.font.inter)
    val bodyFamily = bodyFont.toFontFamily()

    private val displayFont = Font(R.font.inter)
    val displayFamily = displayFont.toFontFamily()

    private val titleFont = Font(R.font.inter)
    val titleFamily = titleFont.toFontFamily()

    private val headLineFont = Font(R.font.inter)
    val headLineFamily = headLineFont.toFontFamily()

    @Composable
    fun adjustFontsSizeInPixelsToSp() {
        if (isAdjusted.not()) {
            labelSmall = convertPixelsToSp(pixels = captionPx)
            labelMedium = convertPixelsToSp(pixels = subHeadPx)
            bodySmall = convertPixelsToSp(pixels = textPx)
            bodyMedium = convertPixelsToSp(pixels = headlinePx)
            titleSmall = convertPixelsToSp(pixels = title3Px)
            titleMedium = convertPixelsToSp(pixels = title2Px)
            titleLarge = convertPixelsToSp(pixels = title1Px)
            isAdjusted = true
        }
    }
}
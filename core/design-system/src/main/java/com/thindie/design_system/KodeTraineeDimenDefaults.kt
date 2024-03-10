package com.thindie.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

object KodeTraineeDimenDefaults {

    private var isAdjusted = false

    private const val cutPix = 4f
    private const val extendedPix = 12f
    private const val fullPix = 16f
    private const val basePix = 8f


    private var cut = 4.dp
    private var extended = 12.dp
    private var full = 16.dp
    private var base = 8.dp

    object PaddingValues {
        val standart by lazy { PaddingValues(horizontal = extended, vertical = base) }
        val fullHorizontalCutVertical by lazy { PaddingValues(horizontal = full, vertical = cut) }
    }

    object Spacing {
        val baseVertical by lazy { base }
        val extendedVertical by lazy { extended }
    }

    object CoderList {
        val height by lazy { base.times(10) }
        val imageSize by lazy { extended.times(6) }
    }

    object BottomSheet {
        val height by lazy { cut.times(15) }
    }

    object SearchBar {
        val height by lazy { cut.times(10) }
    }

    object ProfileInfoBar {
        val height by lazy { cut.times(15) }
    }

    @Composable
    fun adjustPixelsToDp() {
        if (isAdjusted.not()){
            cut = convertPixelsToDp(cutPix)
            extended = convertPixelsToDp(extendedPix)
            base = convertPixelsToDp(basePix)
            full = convertPixelsToDp(fullPix)
            isAdjusted = true
        }
    }
}
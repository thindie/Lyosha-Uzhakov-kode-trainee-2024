package com.thindie.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
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
        val zero by lazy { PaddingValues(0.dp, 0.dp) }
        val standart by lazy { PaddingValues(horizontal = extended, vertical = base) }
        val fullHorizontalCutVertical by lazy { PaddingValues(horizontal = full, vertical = cut) }
    }

    object Spacing {
        val cutHorizontal by lazy { cut }
        val cutVertical by lazy { cut }
        val baseVertical by lazy { base }
        val extendedVertical by lazy { extended }
        val baseHorizontal by lazy { extended }
        val extendedHorizontal by lazy { full }
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

    object DrawableSize {
        val base by lazy { extended.times(2) }
        val medium by lazy { base.times(7) }
        val large by lazy { extended.times(6) }
    }

    @Composable
    fun adjustPixelsToDp(density: Density) {
        if (isAdjusted.not()) {
            cut = convertPixelsToDp(cutPix, density = density)
            extended = convertPixelsToDp(extendedPix, density = density)
            base = convertPixelsToDp(basePix, density = density)
            full = convertPixelsToDp(fullPix, density = density)
            isAdjusted = true
        }
    }
}
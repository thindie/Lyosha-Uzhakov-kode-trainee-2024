package com.thindie.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object KodeTraineeDimen {

    private val cut = 4.dp
    private val extended = 12.dp
    private val full = 16.dp
    private val base = 8.dp
    object PaddingValues {
        val standart = PaddingValues(horizontal = extended, vertical = base)
        val fullHorizontalCutVertical = PaddingValues(horizontal = full, vertical = cut)
    }

    object Spacing {
        val cutHorizontal = cut
        val cutVertical = cut
        val baseVertical = base
        val extendedVertical = extended
        val baseHorizontal = extended
     }

    object CoderList {
        val height = base.times(10)
        val imageSize = extended.times(6)
    }

    object BottomSheet {
        val height = cut.times(15)
    }

    object SearchBar {
        val height = cut.times(10)
    }

    object ProfileInfoBar {
        val height = cut.times(15)
    }

    object DrawableSize{
        val base = extended.times(2)
        val large = extended.times(6)
    }
}
package com.thindie.design_system

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

object KodeTraineeDimenDefaults {

    private val cut = 4.dp
    private val extended = 12.dp
    private val full = 16.dp
    private val baseDimen = 8.dp

    object PaddingValues {
        val standart by lazy { PaddingValues(horizontal = extended, vertical = baseDimen) }
    }

    object Spacing {
        val cutHorizontal by lazy { cut }
        val cutVertical by lazy { cut }
        val baseVertical by lazy { baseDimen }
        val extendedVertical by lazy { extended }
        val baseHorizontal by lazy { extended }
        val extendedHorizontal by lazy { full }
    }

    object CoderList {
        val height by lazy { baseDimen.times(10) }
        val imageSize by lazy { extended.times(6) }
        val stickyHeader by lazy { cut.times(17) }
    }


    object SearchBar {
        val height by lazy { cut.times(10) }
        const val defaultSize = 1f
        const val adjustedSize = 0.6f
    }

    object ProfileScreen {
        val profileInfoTitleHeight by lazy { baseDimen.times(10) }
        val profileInfoSnippetHeight by lazy { cut.times(15) }
    }

    object DrawableSize {
        val base by lazy { extended.times(2) }
        val large by lazy { extended.times(6) }
        val extraLarge by lazy { baseDimen.times(13) }
    }

    object BottomSheet {
        val section by lazy { cut.times(20) }
    }
}
package com.thindie.coders.screen.elements.tabrow

import androidx.annotation.StringRes
import com.thindie.coders.events.CodersScreenViewModelEvent
import com.thindie.model.Department

internal data class TabRowUnit(
    @StringRes val tabRowTitle: Int,
    val department: Department,
)

internal fun TabRowUnit.getAsCodersViewModelEvent(index: Int) =
    CodersScreenViewModelEvent.OnClickTabRow(department = department, index = index)


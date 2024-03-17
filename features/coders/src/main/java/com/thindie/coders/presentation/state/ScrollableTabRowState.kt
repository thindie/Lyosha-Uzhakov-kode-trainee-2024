package com.thindie.coders.presentation.state

import com.thindie.model.Department

internal data class ScrollableTabRowState(val selectedIndex: Int = 0, val department: Department) {
    companion object {
        operator fun invoke() =
            ScrollableTabRowState(selectedIndex = 0, department = Department.UNSPECIFIED)
    }

}
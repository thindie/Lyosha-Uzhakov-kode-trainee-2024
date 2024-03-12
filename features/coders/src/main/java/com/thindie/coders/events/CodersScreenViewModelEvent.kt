package com.thindie.coders.events

import com.thindie.model.Department

sealed interface CodersScreenViewModelEvent {
    data object OnClickAlphabetSort : CodersScreenViewModelEvent
    data object OnClickBirthdaySort : CodersScreenViewModelEvent

    data class OnClickTabRow(val index: Int, val department: Department) :
        CodersScreenViewModelEvent
}
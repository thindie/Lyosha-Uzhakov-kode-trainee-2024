package com.thindie.coders.presentation.events

import com.thindie.model.Department

internal sealed interface CodersScreenViewModelEvent {
    data object OnClickAlphabetSort : CodersScreenViewModelEvent
    data object OnClickBirthdaySort : CodersScreenViewModelEvent

    data object OnFocusSearchBar : CodersScreenViewModelEvent

    data object OnClearSearchBarInput : CodersScreenViewModelEvent

    data object OnDismissFocusSearchBar : CodersScreenViewModelEvent

    data class OnSearchBarValueChange(val fieldValue: String) : CodersScreenViewModelEvent


    data class OnClickTabRow(val index: Int, val department: Department) :
        CodersScreenViewModelEvent
}
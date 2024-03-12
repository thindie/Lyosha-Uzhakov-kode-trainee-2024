package com.thindie.coders.presentation.events

import com.thindie.model.Department

internal sealed interface CodersScreenViewModelEvent {
    data object OnClickAlphabetSort : CodersScreenViewModelEvent
    data object OnClickBirthdaySort : CodersScreenViewModelEvent

    data class OnClickClearSearchBarInput(val shouldResetSearchBarState: Boolean = false) : CodersScreenViewModelEvent

    data object OnClickSearchBarButtonCancel : CodersScreenViewModelEvent

    data class OnSearchBarValueChange(
        val fieldValue: String,
        val shouldResetSearchBarState: Boolean = false,
    ) : CodersScreenViewModelEvent

    data object OnBottomSheetInvoke : CodersScreenViewModelEvent

    data object OnBottomSheetDismiss : CodersScreenViewModelEvent

    data object OnBottomSheetInvoke: CodersScreenViewModelEvent

    data object OnBottomSheetDismiss: CodersScreenViewModelEvent


    data class OnClickTabRow(val index: Int, val department: Department) :
        CodersScreenViewModelEvent
}
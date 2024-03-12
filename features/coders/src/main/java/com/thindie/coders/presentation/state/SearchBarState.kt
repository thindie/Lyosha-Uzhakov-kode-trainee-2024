package com.thindie.coders.presentation.state

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue

internal data class SearchBarState(
    val isFocused: Boolean,
    val isNotEmpty: Boolean,
    val isTrailingIconActivated: Boolean,
    val isLeadingIconActivated: Boolean,
    val fieldValue: String,
) {

    val shouldShowPlaceHolder by derivedStateOf { isFocused.not() && isNotEmpty.not() }
}
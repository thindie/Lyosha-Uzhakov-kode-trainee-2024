package com.thindie.coders.presentation.state

internal data class SearchBarState(
    val shouldShowDefaultState: Boolean,
    val isSortOrGroupSet: Boolean,
    val fieldValue: String,
)
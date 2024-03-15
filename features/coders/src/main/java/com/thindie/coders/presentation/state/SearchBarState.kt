package com.thindie.coders.presentation.state

internal data class SearchBarState(
    val shouldShowDefaultState: Boolean,
    val isSortOrGroupSet: Boolean,
    val fieldValue: String,
) {
    companion object {
        operator fun invoke() = SearchBarState(
            shouldShowDefaultState = true,
            isSortOrGroupSet = false,
            fieldValue = ""
        )
    }

}
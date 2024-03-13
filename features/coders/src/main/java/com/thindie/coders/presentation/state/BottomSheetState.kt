package com.thindie.coders.presentation.state

internal data class BottomSheetState(
    val isExpanded: Boolean,
    val sortType: SortType = SortType.DEFAULT,
) {
    companion object {
        enum class SortType {
            DEFAULT, ALPHABET, DATE
        }
    }
}
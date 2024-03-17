package com.thindie.coders.presentation.state

internal data class BottomSheetState(
    val isExpanded: Boolean,
    val sortType: SortType,
) {
    companion object {
        enum class SortType {
            ALPHABET, DATE
        }

        operator fun invoke() = BottomSheetState(isExpanded = false, sortType = SortType.ALPHABET)
    }
}
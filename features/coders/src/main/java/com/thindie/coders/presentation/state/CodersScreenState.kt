package com.thindie.coders.presentation.state

import com.thindie.common.coreartifacts.ViewState
import com.thindie.model.coders.CoderModel

internal data class CodersScreenState(
    override val isLoading: Boolean,
    override val isError: Boolean,
    val codersList: List<CoderModel>,
    val tabRowState: ScrollableTabRowState,
    val searchBarState: SearchBarState,
) :
    ViewState {

    override fun onError(): ViewState {
        return this.copy(isLoading = false, isError = true)
    }

    override fun onLoading(): ViewState {
        return this.copy(isLoading = true, isError = false)
    }

    override fun onSuccess(): ViewState {
        return this.copy(isLoading = false, isError = false)
    }

    companion object {
        fun getDefault() = CodersScreenState(
            isLoading = false,
            isError = false,
            tabRowState = ScrollableTabRowState(selectedIndex = 0),
            codersList = emptyList(),
            searchBarState = SearchBarState(
                shouldShowDefaultState = true,
                fieldValue = "",
                isSortOrGroupSet = false
            )
        )
    }
}
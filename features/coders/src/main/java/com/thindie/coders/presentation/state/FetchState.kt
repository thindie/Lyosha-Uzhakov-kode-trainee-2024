package com.thindie.coders.presentation.state

internal data class FetchState(
    val isLoading: Boolean,
    val isError: Boolean,
    val isRefresh: Boolean
) {
    companion object {
        operator fun invoke() = FetchState(isLoading = true, isError = false, isRefresh = false)
    }
}
package com.thindie.coders.presentation.state

internal data class FetchState(
    val isLoading: Boolean,
    val isError: Boolean,
) {
    companion object {
        operator fun invoke() = FetchState(isLoading = true, isError = false)
    }
}
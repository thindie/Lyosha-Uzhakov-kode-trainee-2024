package com.thindie.common.coreartifacts


interface ViewState {
    val isLoading: Boolean
    val isError: Boolean
    fun onError() : ViewState
    fun onLoading() : ViewState

    fun onSuccess(): ViewState
}
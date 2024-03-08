package com.thindie.common.coreartifacts

import kotlinx.coroutines.flow.StateFlow

interface ViewStateHolder<T : ViewState> {


    val state: StateFlow<T>

    fun onError()

    fun onLoading()
}
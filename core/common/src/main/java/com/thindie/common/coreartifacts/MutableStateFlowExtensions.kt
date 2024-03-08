package com.thindie.common.coreartifacts

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

private const val SUBSCRIBE_TIME = 5_000L

private val whileSubscribed = SharingStarted.WhileSubscribed(SUBSCRIBE_TIME)

fun <T : ViewState> MutableStateFlow<T>.loading() {
    update {
        it.onError() as T
    }
}


fun <T : ViewState> MutableStateFlow<T>.error() {
    update {
        it.onError() as T
    }
}


fun <T : ViewState> MutableStateFlow<T>.success() {
    update {
        it.onSuccess() as T
    }
}


fun <T> MutableStateFlow<T>.subscribeControlledStateFlow(scope: CoroutineScope): StateFlow<T> {
    return stateIn(scope, whileSubscribed, value)
}

fun <T> Flow<T>.subscribeControlledStateFlow(scope: CoroutineScope, initialValue: T): StateFlow<T> {
    return stateIn(scope, whileSubscribed, initialValue)
}
package com.thindie.common.coreartifacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

fun <T : ViewState, R, H> R.requestResultAndParse(
    request: suspend () -> Result<H>,
    dispatcher: CoroutineDispatcher,
    onSuccess: (H) -> Unit,
) where R : ViewStateHolder<T>, R : ViewModel {
    onLoading()
    viewModelScope.launch(dispatcher) {
        val result = request.invoke()
        result
            .onSuccess { _ ->
                onSuccess(result.getOrThrow())
            }
            .onFailure {
                onError()
            }
    }
}
package com.thindie.coders.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.coders.di.CodersMainScope
import com.thindie.coders.domain.GetCodersListResultUseCase
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.coders.presentation.state.CodersScreenState
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.error
import com.thindie.common.coreartifacts.loading
import com.thindie.common.coreartifacts.requestResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.coreartifacts.success
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@CodersMainScope
internal class CodersScreenViewModel @Inject constructor(private val getCodersUseCase: GetCodersListResultUseCase) :
    ViewModel(),
    ViewStateHolder<CodersScreenState> {

    private val _state = MutableStateFlow(CodersScreenState.getDefault())
    override val state: StateFlow<CodersScreenState> =
        _state.subscribeControlledStateFlow(viewModelScope)

    override fun onError() {
        _state.error()
    }

    override fun onLoading() {
        _state.loading()
    }

    private fun getCoders() {
        requestResultAndParse(request = getCodersUseCase::get, onSuccess = {
            _state.update { stateToUpdate ->
                _state.success()
                stateToUpdate.copy(
                    codersList = it
                )
            }
        })
    }

    fun onEvent(event: CodersScreenViewModelEvent) {
        when (event) {
            CodersScreenViewModelEvent.OnClearSearchBarInput -> {
                _state.update { codersScreenState ->
                    codersScreenState.copy(
                        searchBarState = codersScreenState.searchBarState.copy(
                            fieldValue = ""
                        )
                    )
                }
            }

            CodersScreenViewModelEvent.OnClickAlphabetSort -> {
            }

            CodersScreenViewModelEvent.OnClickBirthdaySort -> {
            }

            is CodersScreenViewModelEvent.OnClickTabRow -> {
                _state.update { codersScreenState ->
                    codersScreenState.copy(
                        tabRowState = codersScreenState.tabRowState.copy(
                            selectedIndex = event.index
                        )
                    )
                }
            }

            CodersScreenViewModelEvent.OnDismissFocusSearchBar -> {
                _state.update { codersScreenState ->
                    codersScreenState.copy(
                        searchBarState = codersScreenState.searchBarState.copy(
                            isFocused = false
                        )
                    )
                }
                onEvent(CodersScreenViewModelEvent.OnClearSearchBarInput)
            }

            CodersScreenViewModelEvent.OnFocusSearchBar -> {
                _state.update { codersScreenState ->
                    codersScreenState.copy(
                        searchBarState = codersScreenState.searchBarState.copy(
                            isFocused = true
                        )
                    )
                }
            }

            is CodersScreenViewModelEvent.OnSearchBarValueChange -> {

                _state.update { codersScreenState ->
                    codersScreenState.copy(
                        searchBarState = codersScreenState.searchBarState.copy(
                            fieldValue = event.fieldValue,
                            isFocused = event.fieldValue.isNotBlank()
                        )
                    )
                }
            }

            CodersScreenViewModelEvent.OnBottomSheetDismiss -> {

            }
            CodersScreenViewModelEvent.OnBottomSheetInvoke -> {

            }
        }
    }

}
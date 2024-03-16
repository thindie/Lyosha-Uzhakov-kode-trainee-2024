package com.thindie.coders.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.coders.di.CodersMainScope
import com.thindie.coders.domain.GetCodersListResultUseCase
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.coders.presentation.state.BottomSheetState
import com.thindie.coders.presentation.state.CodersListSupplier
import com.thindie.coders.presentation.state.CodersScreenState
import com.thindie.coders.presentation.state.FetchState
import com.thindie.coders.presentation.state.ScrollableTabRowState
import com.thindie.coders.presentation.state.SearchBarState
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.requestResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.di.IODispatcher
import com.thindie.model.Department
import com.thindie.model.NotExpectedSideEffectInside
import com.thindie.model.coders.CoderModel
import com.thindie.model.coders.findCoderByNameAndTag
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

@CodersMainScope
internal class CodersScreenViewModel @Inject constructor(
    private val getCodersUseCase: GetCodersListResultUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel(), ViewStateHolder<CodersScreenState> {

    private val _coderListSupplierState = MutableStateFlow(CodersListSupplier())
    private val _tabRowState = MutableStateFlow(ScrollableTabRowState())
    private val _searchBarState = MutableStateFlow(SearchBarState())
    private val _bottomSheetState = MutableStateFlow(BottomSheetState())
    private val _fetchState = MutableStateFlow(FetchState())

    private val _state = combine(
        _coderListSupplierState, _tabRowState, _bottomSheetState, _searchBarState, _fetchState
    ) { listSupplier, tabRow, bottomSheet, searchBar, fetchingProcess ->


        val filteredAndSortedCodersList =
            when (bottomSheet.sortType) {
                BottomSheetState.Companion.SortType.ALPHABET -> listSupplier.codersList.filter { coder ->
                    coder.departmentFilter(tabRow.department)
                }
                    .filter { coder -> coder.findCoderByNameAndTag(searchBar.fieldValue) }
                    .sortedBy(CoderModel::getFullName)

                BottomSheetState.Companion.SortType.DATE -> listSupplier.codersList.filter { coder ->
                    coder.departmentFilter(tabRow.department)
                }
                    .filter { coder -> coder.findCoderByNameAndTag(searchBar.fieldValue) }
                    .sortedBy(CoderModel::dayOfYear)
            }

        CodersScreenState(
            isLoading = fetchingProcess.isLoading,
            isError = filteredAndSortedCodersList.isEmpty(),
            codersList = filteredAndSortedCodersList,
            tabRowState = ScrollableTabRowState(
                selectedIndex = tabRow.selectedIndex, department = tabRow.department
            ),
            searchBarState = SearchBarState(
                shouldShowDefaultState = searchBar.shouldShowDefaultState,
                isSortOrGroupSet = searchBar.isSortOrGroupSet,
                fieldValue = searchBar.fieldValue
            ),
            isRefreshing = fetchingProcess.isRefresh,
            bottomSheetState = BottomSheetState(
                isExpanded = bottomSheet.isExpanded, sortType = bottomSheet.sortType
            )
        )

    }

    override val state: StateFlow<CodersScreenState> =
        _state.subscribeControlledStateFlow(viewModelScope, CodersScreenState.getDefault())

    override fun onError() {}

    override fun onLoading() {
        _fetchState.update { fetchState -> fetchState.copy(isLoading = true) }
    }

    private fun onSuccess() {
        _fetchState.update { fetchState -> fetchState.copy(isLoading = false, isError = false) }
    }

    private fun onRefresh() {
        _fetchState.update { fetchState -> fetchState.copy(isRefresh = true) }
        _fetchState.update { fetchState -> fetchState.copy(isRefresh = false) }
    }

    fun getCoders() {
        @NotExpectedSideEffectInside("Encapsulated current VM state management") requestResultAndParse(
            request = getCodersUseCase::get,
            dispatcher = ioDispatcher,
            onSuccess = {
                onSuccess()
                _coderListSupplierState.update { stateToUpdate ->
                    stateToUpdate.copy(
                        codersList = it
                    )
                }
            })
    }

    fun onEvent(event: CodersScreenViewModelEvent) {
        when (event) {
            is CodersScreenViewModelEvent.OnClickClearSearchBarInput -> {
                onEvent(
                    CodersScreenViewModelEvent.OnSearchBarValueChange(
                        fieldValue = "", shouldResetSearchBarState = event.shouldResetSearchBarState
                    )
                )
            }

            CodersScreenViewModelEvent.OnClickAlphabetSort -> {
                _searchBarState.update { searchBarState ->
                    searchBarState.copy(
                        isSortOrGroupSet = false
                    )
                }
                _bottomSheetState.update { bottomSheetState ->
                    bottomSheetState.copy(sortType = BottomSheetState.Companion.SortType.ALPHABET)
                }
                onEvent(CodersScreenViewModelEvent.OnBottomSheetDismiss)
            }

            CodersScreenViewModelEvent.OnClickBirthdaySort -> {
                _searchBarState.update { searchBarState ->
                    searchBarState.copy(
                        isSortOrGroupSet = true
                    )
                }
                _bottomSheetState.update { bottomSheetState ->
                    bottomSheetState.copy(sortType = BottomSheetState.Companion.SortType.DATE)
                }
                onEvent(CodersScreenViewModelEvent.OnBottomSheetDismiss)
            }

            is CodersScreenViewModelEvent.OnClickTabRow -> {
                _tabRowState.update { tabRowState ->
                    tabRowState.copy(
                        selectedIndex = event.index, department = event.department
                    )
                }
            }

            CodersScreenViewModelEvent.OnClickSearchBarButtonCancel -> {
                onEvent(
                    CodersScreenViewModelEvent.OnClickClearSearchBarInput(
                        shouldResetSearchBarState = true
                    )
                )
            }

            is CodersScreenViewModelEvent.OnSearchBarValueChange -> {
                _searchBarState.update { searchBarState ->
                    searchBarState.copy(
                        fieldValue = event.fieldValue,
                        shouldShowDefaultState = event.shouldResetSearchBarState
                    )
                }
            }

            CodersScreenViewModelEvent.OnBottomSheetDismiss -> {
                _bottomSheetState.update { bottomSheetState ->
                    bottomSheetState.copy(
                        isExpanded = false
                    )
                }
            }

            CodersScreenViewModelEvent.OnBottomSheetInvoke -> {
                _bottomSheetState.update { bottomSheetState ->
                    bottomSheetState.copy(
                        isExpanded = true
                    )
                }
            }

            CodersScreenViewModelEvent.OnRefreshRequest -> {
                onRefresh()
                _coderListSupplierState.value.codersList.ifEmpty {
                    getCoders()
                }
            }
        }
    }
}

private fun CoderModel.departmentFilter(department: Department): Boolean {
    return if (department != Department.UNSPECIFIED) this.department == department
    else true
}


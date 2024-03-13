package com.thindie.coders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thindie.coders.di.CodersMainComponent
import com.thindie.coders.internal_navigation.InternalFeatureRouting
import com.thindie.coders.internal_navigation.alphabetRoute
import com.thindie.coders.internal_navigation.birthdayRoute
import com.thindie.coders.presentation.CodersScreenViewModel
import com.thindie.coders.presentation.elements.alphabetRoute
import com.thindie.coders.presentation.elements.birthdayRoute
import com.thindie.coders.presentation.elements.bottomsheet.KodeTraineeBottomSheet
import com.thindie.coders.presentation.elements.defaultRoute
import com.thindie.coders.presentation.elements.searchbar.KodeTraineeSearchBar
import com.thindie.coders.presentation.elements.tabrow.KodeTraineeScrollableTabRow
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.getAppContract
import com.thindie.design_system.util_ui_snippets.ErrorScreen
import com.thindie.model.NotExpectedSideEffectInside
import com.thindie.model.coders.CoderModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.codersRoute(onClickCoder: (CoderModel) -> Unit) {
    composable(route = KodeTraineeCommon.FeatureDestinations.codersSummary) {
        val daggerComponent = initFeatureDaggerComponent()
        if (daggerComponent != null) {

            val viewModel: CodersScreenViewModel =
                viewModel(factory = daggerComponent.provideFactory())

            viewModel.getCoders()

            val navController = rememberNavController()
            val uiState by viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)
            val modalBottomSheetState = rememberModalBottomSheetState()

            Scaffold(topBar = {
                Column {
                    KodeTraineeSearchBar(
                        searchBarState = uiState.searchBarState, onEvent = viewModel::onEvent
                    )
                    KodeTraineeScrollableTabRow(
                        selectedIndex = uiState.tabRowState.selectedIndex,
                        onClickTab = viewModel::onEvent
                    )
                }
            }) { paddingValues ->
                NavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController,
                    startDestination = InternalFeatureRouting.defaultRoute
                ) {
                    defaultRoute(
                        viewModel = viewModel,
                        onClickCoder = onClickCoder
                    )
                    birthdayRoute(
                        viewModel = viewModel,
                        onClickCoder = onClickCoder
                    )
                    alphabetRoute(
                        viewModel = viewModel,
                        onClickCoder = onClickCoder
                    )
                }
            }
            if (uiState.bottomSheetState.isExpanded) {
                KodeTraineeBottomSheet(
                    state = uiState.bottomSheetState,
                    modalSheetState = modalBottomSheetState,
                    onEvent = {
                        @NotExpectedSideEffectInside("It can navigate through feature")
                        viewModel.onEvent(
                            onBottomSheetEvent(it, navController)
                        )
                    }
                )
            }


        } else ErrorScreen()
    }
}


private fun onBottomSheetEvent(
    event: CodersScreenViewModelEvent,
    navController: NavController,
): CodersScreenViewModelEvent {
    return when (event) {
        CodersScreenViewModelEvent.OnClickAlphabetSort -> {
            navController.alphabetRoute()
            event
        }

        CodersScreenViewModelEvent.OnClickBirthdaySort -> {
            navController.birthdayRoute()
            event
        }

        else -> event
    }
}


@Composable
internal fun initFeatureDaggerComponent(): CodersMainComponent? {
    return getAppContract()?.getDependenciesProvider()?.let { dependenciesProvider ->
        CodersMainComponent.init(dependenciesProvider)
    }
}
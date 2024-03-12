package com.thindie.coders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thindie.coders.di.CodersMainComponent
import com.thindie.coders.internal_navigation.InternalFeatureRouting
import com.thindie.coders.internal_navigation.alphabetRoute
import com.thindie.coders.internal_navigation.birthdayRoute
import com.thindie.coders.internal_navigation.defaultRoute
import com.thindie.coders.presentation.CodersScreenViewModel
import com.thindie.coders.presentation.elements.searchbar.KodeTraineeSearchBar
import com.thindie.coders.presentation.elements.tabrow.KodeTraineeScrollableTabRow
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.getAppContract
import com.thindie.design_system.util_ui_snippets.ErrorScreen

fun NavGraphBuilder.codersRoute() {
    composable(route = KodeTraineeCommon.FeatureDestinations.codersSummary) {
        val daggerComponent = initFeatureDaggerComponent()
        if (daggerComponent != null) {

            val viewModel: CodersScreenViewModel =
                viewModel(factory = daggerComponent.provideFactory())
            val navController = rememberNavController()

            Scaffold { paddingValues ->
                NavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController,
                    startDestination = InternalFeatureRouting.defaultRoute
                ) {
                    defaultRoute(
                        viewModel = viewModel,
                        onClickAlphabet = navController::alphabetRoute,
                        onClickBirthday = navController::birthdayRoute
                    )
                    birthdayRoute(
                        viewModel = viewModel,
                        onClickAlphabet = navController::alphabetRoute,
                        onClickBirthday = navController::birthdayRoute
                    )
                    alphabetRoute(
                        viewModel = viewModel,
                        onClickBirthday = navController::birthdayRoute,
                        onClickDefault = navController::defaultRoute
                    )
                }
            }


        } else ErrorScreen()
    }
}

internal fun NavGraphBuilder.defaultRoute(
    viewModel: CodersScreenViewModel,
    onClickAlphabet: () -> Unit,
    onClickBirthday: () -> Unit,
) {
    composable(route = InternalFeatureRouting.defaultRoute) {

        val uiState by
        viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

        Column {
            KodeTraineeSearchBar(
                searchBarState = uiState.searchBarState,
                onEvent = viewModel::onEvent
            )
            KodeTraineeScrollableTabRow(
                selectedIndex = uiState.tabRowState.selectedIndex,
                onClickTab = viewModel::onEvent
            )
            
            uiState.codersList.forEach { 
                Text(text = it.id)
            }
        }
    }
}

internal fun NavGraphBuilder.alphabetRoute(
    viewModel: CodersScreenViewModel,
    onClickBirthday: () -> Unit,
    onClickDefault: () -> Unit,
) {
    composable(route = InternalFeatureRouting.alphabetRoute) {

    }
}

internal fun NavGraphBuilder.birthdayRoute(
    viewModel: CodersScreenViewModel,
    onClickAlphabet: () -> Unit,
    onClickBirthday: () -> Unit,
) {
    composable(route = InternalFeatureRouting.birthdayRoute) {

    }
}

@Composable
internal fun initFeatureDaggerComponent(): CodersMainComponent? {
    return getAppContract()?.getDependenciesProvider()?.let { dependenciesProvider ->
        CodersMainComponent.init(dependenciesProvider)
    }
}
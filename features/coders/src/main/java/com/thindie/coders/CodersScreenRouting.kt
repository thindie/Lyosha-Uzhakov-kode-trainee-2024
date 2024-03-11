package com.thindie.coders

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
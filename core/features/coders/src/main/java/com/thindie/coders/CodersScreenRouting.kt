package com.thindie.coders

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.coders.di.CodersMainComponent
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.getAppContract
import com.thindie.design_system.util_ui_snippets.ErrorScreen

fun NavGraphBuilder.codersRoute() {
    composable(route = KodeTraineeCommon.FeatureDestinations.codersSummary) {
        val daggerComponent = initFeatureDaggerComponent()
        if (daggerComponent != null) {
            val viewModel: CodersScreenViewModel =
                viewModel(factory = daggerComponent.provideFactory())
        } else ErrorScreen()
    }
}

@Composable
internal fun initFeatureDaggerComponent(): CodersMainComponent? {
    return getAppContract()?.getDependenciesProvider()?.let { dependenciesProvider ->
        CodersMainComponent.init(dependenciesProvider)
    }
}
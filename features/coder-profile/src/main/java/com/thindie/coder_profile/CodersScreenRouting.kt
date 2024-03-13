package com.thindie.coder_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.coder_profile.di.CoderProfileComponent
import com.thindie.coder_profile.presentation.CoderProfileScreenViewModel
import com.thindie.coder_profile.presentation.screen.KodeTraineeCoderProfileScreen
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.getAppContract
import com.thindie.design_system.util_ui_snippets.ErrorScreen

fun NavGraphBuilder.coderProfileRoute(onClickBack: () -> Unit) {
    composable(route = KodeTraineeCommon.FeatureDestinations.coderProfile) {
        val daggerComponent = initFeatureDaggerComponent()
        if (daggerComponent != null) {
            val viewModel: CoderProfileScreenViewModel =
                viewModel(factory = daggerComponent.provideFactory())

            val uiState by viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)
            KodeTraineeCoderProfileScreen(
                profileModel = uiState.coderProfile,
                onClickBack = onClickBack
            )
        } else ErrorScreen()
    }
}

@Composable
internal fun initFeatureDaggerComponent(): CoderProfileComponent? {
    return getAppContract()?.getDependenciesProvider()?.let { dependenciesProvider ->
        CoderProfileComponent.init(dependenciesProvider)
    }
}
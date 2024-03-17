package com.thindie.kodeTrainee

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thindie.coder_profile.coderProfileRoute
import com.thindie.coders.codersRoute
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.coreartifacts.ConnectivityObserver
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.string
import com.thindie.kodeTrainee.navigation_utils.allCodersRoute
import com.thindie.kodeTrainee.navigation_utils.coderProfileRoute
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun KodeTraineeApp(
    appCoordinator: AppCoordinator,
    coroutineDispatcher: CoroutineDispatcher,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    },
) {

    var snackBarColor by remember {
        mutableStateOf(Color.Gray)
    }


    val appCoordinatorState by appCoordinator
        .observe()
        .collectAsStateWithLifecycle(
            initialValue = null
        )
    var shouldShowRelaunchSnack by rememberSaveable {
        mutableStateOf(false)
    }


    when (appCoordinatorState) {
        ConnectivityObserver.Status.Available -> {
            if (shouldShowRelaunchSnack) {
                val relaunch = KodeTraineeStrings.SnackBar.relaunch.string()
                snackBarColor = MaterialTheme.colorScheme.primary
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = relaunch,
                        duration = SnackbarDuration.Long
                    )
                }
                shouldShowRelaunchSnack = false
            }
        }

        ConnectivityObserver.Status.Lost -> {
            if (shouldShowRelaunchSnack.not()) {
                val networkError = KodeTraineeStrings.SnackBar.networkError.string()
                snackBarColor = MaterialTheme.colorScheme.error
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(
                        message = networkError,
                        duration = SnackbarDuration.Long
                    )
                }
                shouldShowRelaunchSnack = true
            }
        }

        else -> {}
    }




    if (appCoordinatorState != ConnectivityObserver.Status.Useless) {
        Scaffold(snackbarHost = {
            SnackbarHost(snackbarHostState) {
                Snackbar(
                    snackbarData = it,
                    contentColor = MaterialTheme.colorScheme.background,
                    containerColor = snackBarColor
                )
            }
        }) { paddingValues ->
            NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                startDestination = KodeTraineeCommon.FeatureDestinations.codersSummary
            ) {
                codersRoute(onClickCoder = { navController.coderProfileRoute(it.id) },
                    onCriticalError = {
                        coroutineScope.launch(coroutineDispatcher)
                        { appCoordinator.loadingRequest() }
                    })
                coderProfileRoute(onClickBack = navController::allCodersRoute)
            }
        }
    }
}

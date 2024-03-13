package com.thindie.kodeTrainee

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.thindie.coder_profile.coderProfileRoute
import com.thindie.coders.codersRoute
import com.thindie.common.KodeTraineeCommon
import com.thindie.kodeTrainee.navigation_utils.allCodersRoute
import com.thindie.kodeTrainee.navigation_utils.coderProfileRoute

@Composable
fun KodeTraineeApp() {

    val navController = rememberNavController()

    Scaffold { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = KodeTraineeCommon.FeatureDestinations.codersSummary
        ) {
            codersRoute(onClickCoder = { navController.coderProfileRoute(it.id) })
            coderProfileRoute(onClickBack = navController::allCodersRoute)
        }
    }
}
package com.thindie.kodeTrainee.navigation_utils

import androidx.navigation.NavController
import com.thindie.common.KodeTraineeCommon

private fun NavController.forward(route: String){
    navigate(route){
        launchSingleTop = true
        restoreState = true
    }
}

internal fun NavController.allCodersRoute(){
    forward(KodeTraineeCommon.FeatureDestinations.codersSummary)
}

internal fun NavController.coderProfileRoute(){
    forward(KodeTraineeCommon.FeatureDestinations.coderProfile)
}
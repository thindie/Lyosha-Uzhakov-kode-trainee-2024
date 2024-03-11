package com.thindie.coders.internal_navigation

import androidx.navigation.NavController

fun NavController.forward(route: String) {
    navigate(route) {
        launchSingleTop = true
        restoreState = true
    }
}

fun NavController.alphabetRoute() = forward(InternalFeatureRouting.alphabetRoute)
fun NavController.birthdayRoute() = forward(InternalFeatureRouting.birthdayRoute)

fun NavController.defaultRoute() = forward(InternalFeatureRouting.defaultRoute)
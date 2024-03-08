package com.thindie.design_system

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically

object KodeTraineeAnimationsSpec {
    object NavTransitions {
        val fadeIn = slideInVertically(
            animationSpec = tween(
                durationMillis = 800
            ),
        ).plus(fadeIn())

        val fadeOut = scaleOut(
            animationSpec = tween(durationMillis = 800)
        ).plus(fadeOut())
    }
}
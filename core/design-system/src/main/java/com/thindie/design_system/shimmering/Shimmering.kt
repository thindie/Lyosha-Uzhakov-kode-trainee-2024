package com.thindie.design_system.shimmering

import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private const val SHIMMER = "shimmer"

@Composable
fun rememberShimmeringState(color: Color, duration: Int): ShimmeringState {
    val transition = rememberInfiniteTransition(label = SHIMMER)
    return remember {
        ShimmeringState(color = color, transition = transition, shimmerDuration = duration)
    }
}

@Stable
class ShimmeringState(
    private val color: Color,
    private val transition: InfiniteTransition,
    private val shimmerDuration: Int,
) {

   private val colorList
        @Composable get() = listOf(
            color,
            color
        ).mapIndexed { index, color ->
            color.copy(
                alpha =
                colorsState(duration = index * 100).value
            )
        }

    val animatedBrush
        @Composable get() = Brush.horizontalGradient(
            colors = colorList,
        )

    @Composable
    fun colorsState(duration: Int): State<Float> {
        return transition.animateFloat(
            initialValue = 0.2f,
            targetValue = 1.0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    delayMillis = duration,
                    durationMillis = shimmerDuration,
                    easing = EaseInBounce
                ),
                repeatMode = RepeatMode.Reverse
            ),
            label = ""
        )
    }
}
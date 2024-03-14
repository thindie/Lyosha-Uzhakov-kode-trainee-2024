package com.thindie.design_system.shimmering

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
fun SimpleShimmer(modifier: Modifier = Modifier) {
    val shimmeringState =
        rememberShimmeringState(color = MaterialTheme.colorScheme.onBackground, duration = 900)
    Column {
        Spacer(
            modifier = modifier
                .size(KodeTraineeDimenDefaults.DrawableSize.large)
                .background(shimmeringState.animatedBrush)
        )
    }
}


@Composable
fun SimpleShimmerModifier(modifier: Modifier = Modifier) {

    Column {
        Spacer(
            modifier = modifier
                .size(KodeTraineeDimenDefaults.DrawableSize.large)
                .shimmerEffect(MaterialTheme.shapes.extraLarge)
        )
    }
}

@Composable
@Preview
fun previewSimpleShimmer() {
    KodeTraineeTheme {
        SimpleShimmer()
        SimpleShimmerModifier()
    }
}
package com.thindie.design_system.shimmering

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
fun KodeTraineeShimmerListUnit(modifier: Modifier = Modifier, brush: Brush) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(KodeTraineeDimenDefaults.CoderList.height),
        horizontalArrangement = Arrangement.spacedBy(KodeTraineeDimenDefaults.Spacing.cutHorizontal),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = modifier
                .size(KodeTraineeDimenDefaults.DrawableSize.large)
                .background(brush, MaterialTheme.shapes.extraLarge)
                .clip(MaterialTheme.shapes.extraLarge)
        )
        Column(
            modifier = modifier
                .fillMaxHeight()
                .wrapContentWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(
                modifier = modifier
                    .width(KodeTraineeDimenDefaults.CoderList.height)
                    .height(KodeTraineeDimenDefaults.Spacing.extendedVertical)
                    .background(brush, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.height(KodeTraineeDimenDefaults.Spacing.cutVertical))
            Spacer(
                modifier = modifier

                    .width(KodeTraineeDimenDefaults.CoderList.height / 2)
                    .height(KodeTraineeDimenDefaults.Spacing.extendedVertical)
                    .background(brush, MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
@Preview
fun previewKodeTraineeShimmerListUnit() {
    KodeTraineeTheme {
        val state = rememberShimmeringState(color = Color.Gray, duration = 900)

        Column(modifier = Modifier.fillMaxWidth()) {
            repeat(5) {
                KodeTraineeShimmerListUnit(brush = state.animatedBrush)
                Spacer(modifier = Modifier.height(KodeTraineeDimenDefaults.Spacing.cutVertical))
            }
        }

    }
}
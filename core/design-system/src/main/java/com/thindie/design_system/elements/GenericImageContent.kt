package com.thindie.design_system.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.thindie.design_system.KodeTraineeDimen
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.painter
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
@Suppress("LongParameterList")
fun KodeTraineeGenericIconComponentRow(
    modifier: Modifier = Modifier,
    painter: Painter,
    iconTint: Color = MaterialTheme.colorScheme.onBackground,
    iconSize: Dp = KodeTraineeDimen.DrawableSize.base,
    contentSpacing: Dp = KodeTraineeDimen.Spacing.baseHorizontal,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            painter = painter,
            contentDescription = null,
            tint = iconTint
        )
        Spacer(modifier = Modifier.width(contentSpacing))
        content()
    }
}


@Composable
@Suppress("LongParameterList")
fun KodeTraineeGenericImageComponentRow(
    modifier: Modifier = Modifier,
    painter: Painter,
    iconSize: Dp = KodeTraineeDimen.DrawableSize.large,
    contentSpacing: Dp = KodeTraineeDimen.Spacing.baseHorizontal,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        Image(
            modifier = Modifier.size(iconSize),
            painter = painter,
            contentDescription = null,

        )
        Spacer(modifier = Modifier.width(contentSpacing))
        content()
    }
}
private const val PREVIEW = "♦◘╩lJjlMWEQy"
@Composable
@Preview
fun previewKodeTraineeGenericIconComponent() {
    KodeTraineeTheme {
        KodeTraineeGenericIconComponentRow(painter = KodeTraineeDrawable.SearchBar.glass.painter()) {
            Text(PREVIEW)
        }
    }
}

@Composable
@Preview
fun previewKodeTraineeGenericImageComponent() {
    KodeTraineeTheme {
        KodeTraineeGenericImageComponentRow(painter = KodeTraineeDrawable.Stub.stubGoose.painter()) {
            Text(PREVIEW)
        }
    }
}
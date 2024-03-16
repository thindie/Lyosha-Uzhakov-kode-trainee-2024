package com.thindie.design_system.util_ui_snippets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentColumn

@Composable
internal fun BaseUtilSnippet(
    modifier: Modifier = Modifier,
    painter: Painter,
    textHeadline: String,
    textLabel: String,
    textClickable: String,
    isClickable: Boolean,
    onClick: () -> Unit = {},
) {
    Box(modifier = modifier.fillMaxSize()) {
        KodeTraineeGenericImageComponentColumn(
            modifier = modifier.align(Alignment.Center),
            painter = painter,
            contentScale = ContentScale.Inside,
            verticalArrangement = Arrangement.spacedBy(KodeTraineeDimenDefaults.Spacing.extendedVertical)
        ) {
            Text(
                text = textHeadline,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.W600
            )
            Text(
                text = textLabel,
                style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            if (isClickable) {
                ClickableText(
                    text = AnnotatedString(textClickable),
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.W600,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        onClick()
                    }
                )
            }
        }
    }
}
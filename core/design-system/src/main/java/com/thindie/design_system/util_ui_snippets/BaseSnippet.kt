package com.thindie.design_system.util_ui_snippets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.elements.KodeTraineeGenericImageComponentColumn
import kotlinx.coroutines.delay

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


    var shouldShowProgress by remember {
        mutableStateOf(false)
    }

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
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
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
                        shouldShowProgress = true
                    }
                )

                LaunchedEffect(key1 = shouldShowProgress, block = {
                    delay(2000)
                    shouldShowProgress = false
                })
            }
        }
        AnimatedVisibility(visible = shouldShowProgress) {
            LinearProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth(),
                strokeCap = StrokeCap.Round
            )
        }
    }
}
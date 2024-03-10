package com.thindie.design_system.util_ui_snippets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.painter
import com.thindie.design_system.string
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
fun ErrorScreen(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    BaseUtilSnippet(
        modifier = modifier,
        painter = KodeTraineeDrawable.ErrorScreen.ufo.painter(),
        textHeadline = KodeTraineeStrings.ErrorScreen.uberMind.string(),
        textLabel = KodeTraineeStrings.ErrorScreen.quickFix.string(),
        textClickable = KodeTraineeStrings.ErrorScreen.tryAgain.string(),
        isClickable = true,
        onClick = onClick
    )
}


@Composable
@Preview
fun previewErrorScreen() {
    KodeTraineeTheme {
        ErrorScreen()
    }
}
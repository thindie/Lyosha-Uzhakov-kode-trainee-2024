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
fun UnsuccessfullSearchSnippet(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    BaseUtilSnippet(
        modifier = modifier,
        painter = KodeTraineeDrawable.SearchResultSnippet.glass.painter(),
        textHeadline = KodeTraineeStrings.SearchFailScreenSnippet.nothingFound.string(),
        textLabel = KodeTraineeStrings.SearchFailScreenSnippet.tryCorrectRequest.string(),
        textClickable = "",
        isClickable = false
    )
}


@Composable
@Preview
fun previewUnsuccessfullSearchSnippet() {
    KodeTraineeTheme {
        UnsuccessfullSearchSnippet()
    }
}
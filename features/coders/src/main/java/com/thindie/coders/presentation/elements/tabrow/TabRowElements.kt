package com.thindie.coders.presentation.elements.tabrow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.string


@Composable
private fun BaseTabRowElement(
    modifier: Modifier = Modifier,
    unit: TabRowUnit,
    textColor: Color,
    fontWeight: FontWeight,
    onClick: () -> Unit,
) {

    Box(modifier = modifier.fillMaxSize()) {
        ClickableText(
            modifier = modifier
                .align(Alignment.Center)
                .padding(KodeTraineeDimenDefaults.PaddingValues.standart),
            style = MaterialTheme.typography.bodySmall.copy(
                color = textColor,
                fontWeight = fontWeight
            ),
            text = AnnotatedString(unit.tabRowTitle.string()),
            onClick = {
                onClick()
            })
    }
}

@Composable
internal fun SelectedTabRowElement(
    modifier: Modifier = Modifier,
    unit: TabRowUnit,
    onClick: () -> Unit,
) {
    BaseTabRowElement(
        modifier = modifier,
        unit = unit,
        textColor = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.W600,
        onClick = onClick
    )
}

@Composable
internal fun TabRowElement(
    modifier: Modifier = Modifier,
    unit: TabRowUnit,
    onClick: () -> Unit,
) {
    BaseTabRowElement(
        modifier = modifier,
        unit = unit,
        textColor = MaterialTheme.colorScheme.onPrimaryContainer,
        fontWeight = FontWeight.W500,
        onClick = onClick
    )
}

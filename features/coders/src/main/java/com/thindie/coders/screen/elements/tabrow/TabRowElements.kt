package com.thindie.coders.screen.elements.tabrow

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    TextButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = KodeTraineeDimenDefaults.PaddingValues.zero
    ) {
        Text(text = unit.tabRowTitle.string(), color = textColor, fontWeight = fontWeight)
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
        textColor = Color.Black,
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
        textColor = Color.Gray,
        fontWeight = FontWeight.W500,
        onClick = onClick
    )
}

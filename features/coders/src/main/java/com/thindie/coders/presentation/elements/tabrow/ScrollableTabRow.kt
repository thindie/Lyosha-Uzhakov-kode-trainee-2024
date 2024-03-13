package com.thindie.coders.presentation.elements.tabrow

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.theme.KodeTraineeTheme

/**
 * ScrollableTabRow на стандартной компоуз реализации. Tab unit межерится под капотом отталкиваясь от хардкод значения, из-за чего вкладки
 * не по дизайну. Можно подправить, но неизвестно, к каким сайд эффектам это может привести.
 * Возможно позже можно будет провести исследование
 */
@Composable
internal fun KodeTraineeScrollableTabRow(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    onClickTab: (CodersScreenViewModelEvent) -> Unit,
) {
    ScrollableTabRow(
        modifier = modifier,
        selectedTabIndex = selectedIndex,
        edgePadding = KodeTraineeDimenDefaults.Spacing.extendedVertical
    ) {
        KodeTraineeTabRowDefaults.tabRowUnitsList
            .forEachIndexed { index, tabRowUnit ->

                val tabUnitClickEvent by lazy { tabRowUnit.getAsCodersViewModelEvent(index) }

                if (index == selectedIndex) SelectedTabRowElement(
                    unit = tabRowUnit,
                    onClick = { onClickTab(tabUnitClickEvent) })
                else TabRowElement(unit = tabRowUnit, onClick = { onClickTab(tabUnitClickEvent) })
            }
    }
}

@Composable
@Preview
internal fun previewKodeTraineeScrollableTabRow_NAIVE_IMPLEMENTATION() {
    KodeTraineeTheme {
        var tabIndex by remember { mutableStateOf(0) }
        KodeTraineeScrollableTabRow(onClickTab = {
            tabIndex = if (tabIndex == 0) 1 else 0
        }, selectedIndex = tabIndex)

    }
}
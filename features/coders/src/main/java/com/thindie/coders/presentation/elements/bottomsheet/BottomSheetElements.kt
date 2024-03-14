package com.thindie.coders.presentation.elements.bottomsheet

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.elements.KodeTraineeGenericIconButtonComponentRow
import com.thindie.design_system.painter
import com.thindie.design_system.string


@Composable
internal fun BottomSheetBirthdateSort(
    isSelected: Boolean,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {
    KodeTraineeBottomSheetUnit(
        title = KodeTraineeStrings.BottomSheet.date,
        isSelected = isSelected
    ) {
        onEvent(CodersScreenViewModelEvent.OnClickBirthdaySort)
    }
}


@Composable
internal fun BottomSheetAlphabetSort(
    isSelected: Boolean,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {
    KodeTraineeBottomSheetUnit(
        title = KodeTraineeStrings.BottomSheet.alphabet,
        isSelected = isSelected
    ) {
        onEvent(CodersScreenViewModelEvent.OnClickAlphabetSort)
    }
}


@Composable
private fun KodeTraineeBottomSheetUnit(
    @StringRes title: Int,
    isSelected: Boolean,
    onEvent: () -> Unit,
) {
    if (isSelected) {
        SelectedBottomSheetItem(
            modifier = Modifier.height(KodeTraineeDimenDefaults.BottomSheet.section),
            title = title,
            onEvent
        )
    } else DefaultBottomSheetItem(
        modifier = Modifier.height(KodeTraineeDimenDefaults.BottomSheet.section),
        title = title,
        onEvent
    )
}


@Composable
private fun SelectedBottomSheetItem(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    onClick: () -> Unit,
) {
    KodeTraineeGenericIconButtonComponentRow(
        modifier = modifier,
        painter = KodeTraineeDrawable.BottomSheet.selected.painter(),
        onClick = onClick
    ) {
        Text(
            text = title.string(),
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun DefaultBottomSheetItem(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    onClick: () -> Unit,
) {
    KodeTraineeGenericIconButtonComponentRow(
        modifier = modifier,
        painter = KodeTraineeDrawable.BottomSheet.unselected.painter(),
        onClick = onClick
    ) {
        Text(
            text = title.string(),
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
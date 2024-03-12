package com.thindie.coders.presentation.elements.bottomsheet

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
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
        SelectedBottomSheetItem(title = title, onEvent)
    } else DefaultBottomSheetItem(title = title, onEvent)
}


@Composable
private fun SelectedBottomSheetItem(@StringRes title: Int, onClick: () -> Unit) {
    KodeTraineeGenericIconButtonComponentRow(
        painter = KodeTraineeDrawable.BottomSheet.selected.painter(),
        onClick = onClick
    ) {
        Text(text = title.string())
    }
}

@Composable
private fun DefaultBottomSheetItem(@StringRes title: Int, onClick: () -> Unit) {
    KodeTraineeGenericIconButtonComponentRow(
        painter = KodeTraineeDrawable.BottomSheet.unselected.painter(),
        onClick = onClick
    ) {
        Text(text = title.string())
    }
}
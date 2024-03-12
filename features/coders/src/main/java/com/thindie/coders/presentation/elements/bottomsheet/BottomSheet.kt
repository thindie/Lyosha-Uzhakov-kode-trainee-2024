package com.thindie.coders.presentation.elements.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.coders.presentation.state.BottomSheetState
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeShapesDefaults
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.string

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun KodeTraineeBottomSheet(
    modifier: Modifier = Modifier,
    state: BottomSheetState,
    modalSheetState: SheetState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {

    LaunchedEffect(key1 = state.isExpanded, block = {
        if (state.isExpanded) modalSheetState.partialExpand()
        else modalSheetState.hide()
    })


    ModalBottomSheet(
        modifier = modifier.padding(KodeTraineeDimenDefaults.Spacing.baseHorizontal),
        sheetState = modalSheetState,
        onDismissRequest = { onEvent.invoke(CodersScreenViewModelEvent.OnBottomSheetDismiss) },
        shape = KodeTraineeShapesDefaults.bottomSheet
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(KodeTraineeDimenDefaults.Spacing.baseVertical)
        ) {
            Text(text = KodeTraineeStrings.BottomSheet.title.string())
            BottomSheetAlphabetSort(
                isSelected = state.sortType == BottomSheetState.Companion.SortType.ALPHABET,
                onEvent = onEvent
            )
            BottomSheetBirthdateSort(
                isSelected = state.sortType == BottomSheetState.Companion.SortType.DATE,
                onEvent = onEvent
            )
        }
    }
}
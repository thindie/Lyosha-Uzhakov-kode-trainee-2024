package com.thindie.coders.presentation.elements.searchbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.coders.presentation.state.SearchBarState
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeDrawable
import com.thindie.design_system.KodeTraineeShapesDefaults
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.painter
import com.thindie.design_system.string
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
@Preview
fun previewKodeTraineeSearchBar() {
    KodeTraineeTheme {
        KodeTraineeSearchBar(modifier = Modifier, searchBarState = SearchBarState(
            shouldShowDefaultState = false, fieldValue = "", isSortOrGroupSet = false
        ), onEvent = {})
    }
}


@Composable
internal fun KodeTraineeSearchBar(
    modifier: Modifier = Modifier,
    searchBarState: SearchBarState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = modifier.animateContentSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BaseSearchBar(
            modifier = modifier,
            state = searchBarState,
            onEvent = onEvent,
        )
        AnimatedVisibility(visible = searchBarState.shouldShowDefaultState.not()) {
            TextButton(onClick = {
                keyboardController?.hide()
                onEvent(CodersScreenViewModelEvent.OnClickSearchBarButtonCancel)
            }) {
                Text(text = KodeTraineeStrings.SearchBar.cancelButton.string())
            }
        }
    }

}


@Composable
private fun BaseSearchBar(
    modifier: Modifier = Modifier,
    state: SearchBarState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(
                if (state.shouldShowDefaultState)
                    KodeTraineeDimenDefaults.SearchBar.defaultSize
                else KodeTraineeDimenDefaults.SearchBar.adjustedSize
            )
            .clip(KodeTraineeShapesDefaults.searchBar)
            .background(Color.LightGray, KodeTraineeShapesDefaults.searchBar)
            .wrapContentHeight(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(KodeTraineeDimenDefaults.PaddingValues.standart),
            value = state.fieldValue,
            leadingIcon = { SearchIcon(state = state) },
            trailingIcon = { VariableTrailingIcon(state = state, onEvent = onEvent) },
            onValueChange = { fieldValue ->
                onEvent(CodersScreenViewModelEvent.OnSearchBarValueChange(fieldValue))
            },
            placeholder = { if (state.shouldShowDefaultState) SearchBarPlaceHolder() },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent,
            )
        )
    }
}

@Composable
private fun VariableTrailingIcon(
    state: SearchBarState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {
    if (state.shouldShowDefaultState.not()) DismissInputIcon(onEvent = onEvent) else SortOrGroupIcon(
        state = state,
        onEvent = onEvent
    )
}

@Composable
private fun SearchIcon(state: SearchBarState) {

    BaseSearchBarIcon(painter = KodeTraineeDrawable.SearchBar.glass.painter(),
        tint = if (state.shouldShowDefaultState.not()) Color.Black else Color.Gray,
        isEnabled = false,
        onEvent = {})
}

@Composable
private fun SearchBarPlaceHolder() {
    Text(text = KodeTraineeStrings.SearchBar.placeHolder.string())
}

@Composable
private fun BaseSearchBarIcon(
    painter: Painter,
    isEnabled: Boolean,
    tint: Color,
    onEvent: () -> Unit,
) {
    IconButton(onClick = onEvent, enabled = isEnabled) {
        Icon(painter = painter, contentDescription = null, tint = tint)
    }

}


@Composable
private fun SortOrGroupIcon(state: SearchBarState, onEvent: (CodersScreenViewModelEvent) -> Unit) {
    BaseSearchBarIcon(painter = KodeTraineeDrawable.SearchBar.options.painter(),
        isEnabled = true,
        tint = if (state.isSortOrGroupSet) MaterialTheme.colorScheme.primary else Color.Gray,
        onEvent = { onEvent(CodersScreenViewModelEvent.OnBottomSheetInvoke) })
}

@Composable
private fun DismissInputIcon(onEvent: (CodersScreenViewModelEvent) -> Unit) {
    BaseSearchBarIcon(painter = KodeTraineeDrawable.SearchBar.cancel.painter(),
        isEnabled = true,
        tint = Color.Gray,
        onEvent = {
            onEvent(
                CodersScreenViewModelEvent.OnClickClearSearchBarInput(
                    shouldResetSearchBarState = false
                )
            )
        })
}
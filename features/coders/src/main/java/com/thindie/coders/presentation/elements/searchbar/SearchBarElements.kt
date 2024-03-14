package com.thindie.coders.presentation.elements.searchbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
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
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BaseSearchBar(
            modifier = modifier.height(KodeTraineeDimenDefaults.SearchBar.height),
            textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onBackground),
            interactionSource = interactionSource,
            state = searchBarState,
            onEvent = onEvent,
        )
        AnimatedVisibility(
            visible = searchBarState.shouldShowDefaultState.not(),
            enter = fadeIn(
                animationSpec = tween(delayMillis = 300),
            ),
            exit = fadeOut(tween(delayMillis = 0))
        ) {
            TextButton(
                modifier = modifier.height(KodeTraineeDimenDefaults.SearchBar.height),
                onClick = {
                    keyboardController?.hide()
                    onEvent(CodersScreenViewModelEvent.OnClickSearchBarButtonCancel)
                    interactionSource.tryEmit(FocusInteraction.Unfocus(FocusInteraction.Focus()))
                }) {
                Text(text = KodeTraineeStrings.SearchBar.cancelButton.string())
            }
        }


    }
}


@Composable
private fun BaseSearchBar(
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    state: SearchBarState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
    interactionSource: MutableInteractionSource,
) {
    val searchBarWidth by animateFloatAsState(
        targetValue = if (state.shouldShowDefaultState) KodeTraineeDimenDefaults.SearchBar.defaultSize
        else KodeTraineeDimenDefaults.SearchBar.adjustedSize,
        label = "",
    )
    Row(
        modifier = modifier
            .fillMaxWidth(searchBarWidth)
            .clip(KodeTraineeShapesDefaults.searchBar)
            .background(
                MaterialTheme.colorScheme.primaryContainer, KodeTraineeShapesDefaults.searchBar
            )
            .wrapContentHeight(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start
    ) {
        KodeTraineeTextField(
            modifier = Modifier
                .height(KodeTraineeDimenDefaults.SearchBar.height)
                .fillMaxWidth(),
            value = state.fieldValue,
            interactionSource = interactionSource,
            textStyle = textStyle,
            leadingIcon = { SearchIcon(state = state) },
            trailingIcon = { VariableTrailingIcon(state = state, onEvent = onEvent) },
            onValueChange = { fieldValue ->
                onEvent(CodersScreenViewModelEvent.OnSearchBarValueChange(fieldValue))
            },
            placeholder = { if (state.shouldShowDefaultState) SearchBarPlaceHolder() },
            singleLine = true,

            )
    }
}

@Suppress("LongParameterList")
@Composable
fun KodeTraineeTextField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle,
    leadingIcon: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    singleLine: Boolean,
    interactionSource: MutableInteractionSource,
) {

    //todo() see design searchbar impl
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        modifier = modifier,
        value = value,
        singleLine = singleLine,
        onValueChange = onValueChange,
        textStyle = textStyle,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                leadingIcon()
                Row(
                    modifier = modifier.fillMaxWidth(KodeTraineeDimenDefaults.SearchBar.adjustedSize),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isFocused) innerTextField()
                    else placeholder()
                    trailingIcon()
                }
            }
        }
    )
}


@Composable
private fun VariableTrailingIcon(
    state: SearchBarState,
    onEvent: (CodersScreenViewModelEvent) -> Unit,
) {
    if (state.shouldShowDefaultState.not()) DismissInputIcon(onEvent = onEvent) else SortOrGroupIcon(
        state = state, onEvent = onEvent
    )
}

@Composable
private fun SearchIcon(state: SearchBarState) {

    BaseSearchBarIcon(painter = KodeTraineeDrawable.SearchBar.glass.painter(),
        tint = if (state.shouldShowDefaultState.not()) MaterialTheme.colorScheme.onBackground
        else MaterialTheme.colorScheme.onPrimaryContainer,
        isEnabled = false,
        onEvent = {})
}

@Composable
private fun SearchBarPlaceHolder() {
    Text(
        text = KodeTraineeStrings.SearchBar.placeHolder.string(),
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onPrimaryContainer
    )
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
        tint = if (state.isSortOrGroupSet) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.onPrimaryContainer,
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
package com.thindie.coders.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thindie.coders.internal_navigation.InternalFeatureRouting
import com.thindie.coders.presentation.CodersScreenViewModel
import com.thindie.coders.presentation.elements.codersList.CoderListUnitAlphabet
import com.thindie.coders.presentation.elements.codersList.CoderListUnitBirthDay
import com.thindie.coders.presentation.events.CodersScreenViewModelEvent
import com.thindie.coders.presentation.state.CodersScreenState
import com.thindie.coders.presentation.state.FetchState
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.design_system.itemsMap
import com.thindie.design_system.shimmering.KodeTraineeShimmerListUnit
import com.thindie.design_system.shimmering.shimmerEffect
import com.thindie.design_system.string
import com.thindie.design_system.util_ui_snippets.UnsuccessfullSearchSnippet
import com.thindie.model.NotExpectedSideEffectInside
import com.thindie.model.coders.CoderModel
import kotlinx.coroutines.delay


internal fun NavGraphBuilder.loadingRoute(
    onShimmerComplete: () -> Unit,
) {
    composable(route = InternalFeatureRouting.loadingRoute) {
        ShimmeredList()
        LaunchedEffect(key1 = true, block = {
            delay(FetchState.fetchStateDelay)
            onShimmerComplete()
        })
    }
}

internal fun NavGraphBuilder.alphabetRoute(
    viewModel: CodersScreenViewModel,
    onClickCoder: (CoderModel) -> Unit,
) {
    composable(route = InternalFeatureRouting.alphabetRoute) {

        val uiState by viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

        @NotExpectedSideEffectInside("Pull Refresh")
        CoderScreenContentAdjuster(state = uiState, onRefresh = viewModel::onEvent) {
            defaultCoderList(uiState, onClickCoder)
        }
    }
}


internal fun NavGraphBuilder.birthdayRoute(
    viewModel: CodersScreenViewModel,
    onClickCoder: (CoderModel) -> Unit,
) {
    composable(route = InternalFeatureRouting.birthdayRoute) {

        val uiState by viewModel.state.collectAsStateWithLifecycle(minActiveState = Lifecycle.State.RESUMED)

        @NotExpectedSideEffectInside("Pull Refresh") CoderScreenContentAdjuster(
            state = uiState,
            onRefresh = viewModel::onEvent
        ) {
            groupedCoderList(uiState, onClickCoder)
        }
    }
}

private fun LazyListScope.defaultCoderList(
    state: CodersScreenState,
    onClickCoder: (CoderModel) -> Unit,
) {
    items(state.codersList, key = CoderModel::id) { coder ->
        CoderListUnitAlphabet(coderModel = coder,
            modifier = Modifier.clickable { onClickCoder(coder) })
    }
}

private fun LazyListScope.groupedCoderList(
    state: CodersScreenState,
    onClickCoder: (CoderModel) -> Unit,
) {
    itemsMap(state.codersList.groupBy(CoderModel::getNearestCelebrationYearOrBlank),
        headerContent = { header ->
            StickyHeader(header = header)
        }) { codersList ->
        codersList.forEach { coder ->
            CoderListUnitBirthDay(coderModel = coder,
                modifier = Modifier.clickable { onClickCoder(coder) })
            Spacer(modifier = Modifier.height(KodeTraineeDimenDefaults.Spacing.baseVertical))
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CoderScreenContentAdjuster(
    modifier: Modifier = Modifier,
    state: CodersScreenState,
    onRefresh: (CodersScreenViewModelEvent) -> Unit,
    codersContent: LazyListScope.() -> Unit,
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isRefreshing,
        onRefresh = { onRefresh(CodersScreenViewModelEvent.OnRefreshRequest) }
    )
    if (state.isError) UnsuccessfullSearchSnippet()
    else LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .pullRefresh(pullRefreshState)
            .wrapContentHeight()
            .padding(all = KodeTraineeDimenDefaults.Spacing.extendedHorizontal),
        verticalArrangement = Arrangement.spacedBy(KodeTraineeDimenDefaults.Spacing.baseVertical)
    ) {
        codersContent()
    }
    Box(modifier = Modifier.fillMaxWidth()) {
        PullRefreshIndicator(
            refreshing = state.isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = MaterialTheme.colorScheme.background,
            contentColor = if (state.isRefreshing) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onBackground
        )
    }


}


@Composable
private fun StickyHeader(modifier: Modifier = Modifier, header: String) {

    val dividerModifier = Modifier.width(KodeTraineeDimenDefaults.CoderList.imageSize)
    val dividerColor = MaterialTheme.colorScheme.onPrimaryContainer
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .height(KodeTraineeDimenDefaults.CoderList.stickyHeader),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Divider(
            modifier = dividerModifier.padding(start = KodeTraineeDimenDefaults.Spacing.baseHorizontal),
            color = dividerColor
        )
        Text(
            text = header.ifBlank { KodeTraineeStrings.CoderList.birthdayStub.string() },
            color = dividerColor,
            style = MaterialTheme.typography.labelSmall
        )
        Divider(
            modifier = dividerModifier.padding(end = KodeTraineeDimenDefaults.Spacing.baseHorizontal),
            color = dividerColor
        )
    }

}

@Composable
fun ShimmeredList(times: Int = 10) {
    Column(
        modifier = Modifier
            .padding(KodeTraineeDimenDefaults.PaddingValues.standart)
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        repeat(times) {
            KodeTraineeShimmerListUnit(
                brush = SolidColor(Color.Transparent),
                modifier = Modifier.shimmerEffect(MaterialTheme.shapes.extraLarge)
            )
            Spacer(modifier = Modifier.height(KodeTraineeDimenDefaults.Spacing.cutVertical))
        }
    }
}
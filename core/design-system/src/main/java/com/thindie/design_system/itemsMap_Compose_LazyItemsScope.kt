package com.thindie.design_system

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
inline fun <T, R> LazyListScope.itemsMap(
    map: Map<T, R>,
    noinline key: ((item: R) -> Any)? = null,
    noinline contentType: (item: R) -> Any? = { null },
    crossinline headerContent: @Composable (item: T) -> Unit,
    crossinline itemsContent: @Composable LazyItemScope.(item: R) -> Unit,
) {
    map.forEach {
        stickyHeader { headerContent(it.key) }

        item(
            key = if (key != null) { index: Int -> index } else null,
            contentType = { index: Int -> contentType(it.value) }
        ) {
            itemsContent(it.value)
        }
    }
}

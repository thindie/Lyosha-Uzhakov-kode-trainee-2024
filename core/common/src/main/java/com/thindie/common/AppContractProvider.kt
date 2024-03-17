package com.thindie.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun getAppContract(): App? {
    val context = LocalContext.current
    return if (context is App) {
        context as? App
    } else null
}

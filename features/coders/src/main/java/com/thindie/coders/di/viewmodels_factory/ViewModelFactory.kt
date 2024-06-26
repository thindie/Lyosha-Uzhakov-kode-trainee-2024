package com.thindie.coders.di.viewmodels_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thindie.coders.di.CodersMainScope
import javax.inject.Inject
import javax.inject.Provider
@Suppress("UNCHECKED_CAST")
@CodersMainScope
internal class ViewModelFactory @Inject constructor(
    private val viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelsProvider = requireNotNull(viewModels[modelClass]) {
        }
        return viewModelsProvider.get() as T
    }
}
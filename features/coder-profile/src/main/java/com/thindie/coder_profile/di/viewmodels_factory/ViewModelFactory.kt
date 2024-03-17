package com.thindie.coder_profile.di.viewmodels_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thindie.coder_profile.di.CoderProfileScope
import javax.inject.Inject
import javax.inject.Provider
@Suppress("UNCHECKED_CAST")
@CoderProfileScope
internal class ViewModelFactory @Inject constructor(
    private val viewModels: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelsProvider = requireNotNull(viewModels[modelClass]) {
        }
        return viewModelsProvider.get() as T
    }
}
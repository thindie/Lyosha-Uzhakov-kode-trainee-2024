package com.thindie.coders.di.viewmodels_factory

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module()
internal interface ViewModelFactoryModule {
    @Binds
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
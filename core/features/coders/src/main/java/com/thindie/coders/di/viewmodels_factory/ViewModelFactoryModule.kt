package com.thindie.coders.di.viewmodels_factory

import androidx.lifecycle.ViewModelProvider
import com.thindie.coders.di.CodersMainScope
import dagger.Binds
import dagger.Module

@Module()
internal interface ViewModelFactoryModule {
    @Binds
    @CodersMainScope
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
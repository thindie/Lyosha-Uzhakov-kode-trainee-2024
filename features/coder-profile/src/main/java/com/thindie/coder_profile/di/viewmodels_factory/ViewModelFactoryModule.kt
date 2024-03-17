package com.thindie.coder_profile.di.viewmodels_factory

import androidx.lifecycle.ViewModelProvider
import com.thindie.coder_profile.di.CoderProfileScope
import dagger.Binds
import dagger.Module

@Module()
internal interface ViewModelFactoryModule {
    @Binds
    @CoderProfileScope
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
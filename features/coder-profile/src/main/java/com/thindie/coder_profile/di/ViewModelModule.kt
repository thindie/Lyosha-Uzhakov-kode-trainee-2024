package com.thindie.coder_profile.di

import androidx.lifecycle.ViewModel
import com.thindie.coder_profile.presentation.CoderProfileScreenViewModel
import com.thindie.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {
    @Binds
    @CoderProfileScope
    @IntoMap
    @ViewModelKey(CoderProfileScreenViewModel::class)
    fun bindViewModel(codersScreenViewModel: CoderProfileScreenViewModel): ViewModel
}
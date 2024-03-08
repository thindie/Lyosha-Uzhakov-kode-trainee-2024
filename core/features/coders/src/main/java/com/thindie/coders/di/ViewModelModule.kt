package com.thindie.coders.di

import androidx.lifecycle.ViewModel
import com.thindie.coders.CodersScreenViewModel
import com.thindie.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CodersScreenViewModel::class)
    fun bindViewModel(codersScreenViewModel: CodersScreenViewModel): ViewModel
}
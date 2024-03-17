package com.thindie.database.di

import com.thindie.database.LocalSourceAdapter
import com.thindie.database.implementation.LocalSourceAdapterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface AdapterModule {

    @Binds
    @Singleton
    fun bindAdapter(impl: LocalSourceAdapterImpl): LocalSourceAdapter
}
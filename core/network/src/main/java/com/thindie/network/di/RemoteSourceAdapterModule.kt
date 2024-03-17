package com.thindie.network.di

import com.thindie.network.RemoteSourceAdapter
import com.thindie.network.implementation.RemoteSourceAdapterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RemoteSourceAdapterModule {
    @Binds
    @Singleton
    fun getRemoteSourceAdapter(impl: RemoteSourceAdapterImpl): RemoteSourceAdapter
}
package com.thindie.common.di

import com.thindie.common.coreartifacts.ConnectivityObserver
import com.thindie.common.coreartifacts.NetworkConnectivityObserver
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface ConnectivityObserverModule {
    @Binds
    @Singleton
    fun bindConnectivityObserver(observer: NetworkConnectivityObserver): ConnectivityObserver
}
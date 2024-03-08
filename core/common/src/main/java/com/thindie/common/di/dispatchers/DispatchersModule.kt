package com.thindie.common.di.dispatchers

import com.thindie.common.di.IODispatcher
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
internal class DispatchersModule {
    @Provides
    @Singleton
    @IODispatcher
    fun provideIoDispatchers(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}
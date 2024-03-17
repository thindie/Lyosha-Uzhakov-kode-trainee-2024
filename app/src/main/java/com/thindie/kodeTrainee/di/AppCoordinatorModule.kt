package com.thindie.kodeTrainee.di

import com.thindie.kodeTrainee.AppCoordinator
import com.thindie.kodeTrainee.data.AppCoordinatorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface AppCoordinatorModule {
    @Binds
    @Singleton
    fun bindAppCoordinator(impl: AppCoordinatorImpl): AppCoordinator
}
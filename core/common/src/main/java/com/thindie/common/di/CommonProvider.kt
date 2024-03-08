package com.thindie.common.di

import kotlinx.coroutines.CoroutineDispatcher

interface CommonProvider {
   
    @IODispatcher
    fun provideCoroutineDispatcher(): CoroutineDispatcher
}
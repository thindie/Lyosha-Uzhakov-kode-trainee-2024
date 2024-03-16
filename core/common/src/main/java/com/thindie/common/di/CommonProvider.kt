package com.thindie.common.di

import com.thindie.common.coreartifacts.ConnectivityObserver
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.common.timemanagement.TimeOperatorFormatter
import kotlinx.coroutines.CoroutineDispatcher

interface CommonProvider {

    @IODispatcher
    fun provideCoroutineDispatcher(): CoroutineDispatcher

    fun provideTimeOperator(): TimeOperator

    fun provideTimeOperatorFormatter(): TimeOperatorFormatter

    fun provideConnectivityObserver(): ConnectivityObserver
}
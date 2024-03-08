package com.thindie.common.timemanagement.di

import com.thindie.common.timemanagement.TimeOperator
import com.thindie.common.timemanagement.TimeOperatorFormatter
import com.thindie.common.timemanagement.repository.TimeOperatorFormatterImpl
import com.thindie.common.timemanagement.repository.TimeOperatorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface TimeOperatorModule {
    @Binds
    @Singleton
    fun bindTimeOperatorProvider(impl: TimeOperatorImpl): TimeOperator

    @Binds
    @Singleton
    fun bindTimeProvider(impl: TimeOperatorFormatterImpl): TimeOperatorFormatter
}
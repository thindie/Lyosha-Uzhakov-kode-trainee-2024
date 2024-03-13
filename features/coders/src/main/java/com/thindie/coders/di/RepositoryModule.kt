package com.thindie.coders.di

import com.thindie.coders.data.CodersRepositoryImpl
import com.thindie.coders.domain.CodersRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {
    @Binds
    @CodersMainScope
    fun bindRepository(impl: CodersRepositoryImpl): CodersRepository
}
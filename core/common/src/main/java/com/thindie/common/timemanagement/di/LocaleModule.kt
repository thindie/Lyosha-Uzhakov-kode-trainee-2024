package com.thindie.common.timemanagement.di

import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

@Module
internal class LocaleModule {
    @Provides
    @Singleton
    fun provideLocale(): Locale {
        return Locale.getDefault()
    }
}
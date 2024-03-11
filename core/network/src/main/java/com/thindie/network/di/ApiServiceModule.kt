package com.thindie.network.di

import com.thindie.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
internal class ApiServiceModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
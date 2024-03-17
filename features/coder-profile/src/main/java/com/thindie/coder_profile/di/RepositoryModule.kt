package com.thindie.coder_profile.di

import com.thindie.coder_profile.data.CoderProfileRepositoryImpl
import com.thindie.coder_profile.domain.CoderProfileRepository
import dagger.Binds
import dagger.Module

@Module
internal interface RepositoryModule {
    @Binds
    @CoderProfileScope
    fun bindRepository(impl: CoderProfileRepositoryImpl): CoderProfileRepository
}
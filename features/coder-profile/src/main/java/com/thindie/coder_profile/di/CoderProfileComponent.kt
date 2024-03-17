package com.thindie.coder_profile.di


import androidx.lifecycle.ViewModelProvider
import com.thindie.coder_profile.di.viewmodels_factory.ViewModelFactoryModule
import com.thindie.common.DependenciesProvider
import dagger.Component


@CoderProfileScope
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [ViewModelFactoryModule::class, ViewModelModule::class, RepositoryModule::class]
)
interface CoderProfileComponent {
    companion object {
        fun init(dependenciesProvider: DependenciesProvider): CoderProfileComponent {

            return DaggerCoderProfileComponent.factory()
                .create(dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependenciesProvider: DependenciesProvider): CoderProfileComponent
    }

    fun provideFactory(): ViewModelProvider.Factory

}
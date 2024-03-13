package com.thindie.coders.di


import androidx.lifecycle.ViewModelProvider
import com.thindie.coders.di.viewmodels_factory.ViewModelFactoryModule
import com.thindie.coders.domain.CodersRepository
import com.thindie.common.DependenciesProvider
import dagger.Component


@CodersMainScope
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [ViewModelFactoryModule::class, ViewModelModule::class, RepositoryModule::class]
)
interface CodersMainComponent {
    companion object {
        fun init(dependenciesProvider: DependenciesProvider): CodersMainComponent {

            return DaggerCodersMainComponent.factory().create(dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(dependenciesProvider: DependenciesProvider): CodersMainComponent
    }

    fun provideFactory(): ViewModelProvider.Factory

}
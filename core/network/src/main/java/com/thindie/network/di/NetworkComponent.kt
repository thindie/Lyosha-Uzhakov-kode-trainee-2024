package com.thindie.network.di

import com.thindie.network.ServiceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface NetworkComponent: ServiceProvider {
    companion object {
        fun init(baseUrl: String): NetworkComponent {
            return DaggerNetworkComponent
                .factory()
                .create(baseUrl)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance baseUrl: String): NetworkComponent
    }

}
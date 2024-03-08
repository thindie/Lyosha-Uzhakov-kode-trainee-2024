package com.thindie.di

import android.content.Context
import com.thindie.common.DependenciesProvider
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.di.CommonProvider
import com.thindie.common.di.CommonsComponent
import com.thindie.network.ServiceProvider
import com.thindie.network.di.NetworkComponent
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [ServiceProvider::class, CommonProvider::class])

internal interface AppComponent: DependenciesProvider {
    companion object{
        fun init(context: Context): AppComponent{
            val serviceProvider = NetworkComponent.init(baseUrl = KodeTraineeCommon.RemoteSource.baseUrl)
            val commonProvider = CommonsComponent.init()
            return DaggerAppComponent
                .factory()
                .create(context, commonProvider, serviceProvider)
        }
    }
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context,
                   commonProvider: CommonProvider,
                   networkProvider: ServiceProvider): AppComponent
    }
}
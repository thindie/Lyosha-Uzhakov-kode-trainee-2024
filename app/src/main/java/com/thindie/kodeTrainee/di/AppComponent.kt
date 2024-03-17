package com.thindie.kodeTrainee.di

import android.content.Context
import com.thindie.common.DependenciesProvider
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.di.CommonProvider
import com.thindie.common.di.CommonsComponent
import com.thindie.database.LocalSourceProvider
import com.thindie.database.di.LocalSourceComponent
import com.thindie.kodeTrainee.MainActivity
import com.thindie.network.ServiceProvider
import com.thindie.network.di.NetworkComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [ServiceProvider::class, CommonProvider::class, LocalSourceProvider::class],
    modules = [AppCoordinatorModule::class]
)
@Singleton
internal interface AppComponent : DependenciesProvider {
    companion object {
        fun init(context: Context): AppComponent {
            val serviceProvider =
                NetworkComponent.init(baseUrl = KodeTraineeCommon.RemoteSource.baseUrl)
            val commonProvider = CommonsComponent.init(context)
            val localSourceProvider = LocalSourceComponent.init(context)
            return DaggerAppComponent.factory()
                .create(context, commonProvider, serviceProvider, localSourceProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            commonProvider: CommonProvider,
            networkProvider: ServiceProvider,
            localSourceProvider: LocalSourceProvider,
        ): AppComponent
    }

    fun inject(activity: MainActivity)
}
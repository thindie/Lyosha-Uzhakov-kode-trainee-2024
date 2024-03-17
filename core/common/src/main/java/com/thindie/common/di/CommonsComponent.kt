package com.thindie.common.di

import android.content.Context
import com.thindie.common.di.dispatchers.DispatchersModule
import com.thindie.common.timemanagement.di.DateTimeFormatterModule
import com.thindie.common.timemanagement.di.LocaleModule
import com.thindie.common.timemanagement.di.TimeOperatorModule
import com.thindie.common.timemanagement.di.TimeZoneModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DispatchersModule::class,
        DateTimeFormatterModule::class,
        LocaleModule::class,
        TimeOperatorModule::class,
        ConnectivityObserverModule::class,
        TimeZoneModule::class]
)
interface CommonsComponent : CommonProvider {
    companion object {
        fun init(context: Context): CommonsComponent {
            return DaggerCommonsComponent
                .factory()
                .create(context)
        }

    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CommonsComponent
    }
}
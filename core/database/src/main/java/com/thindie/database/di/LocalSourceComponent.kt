package com.thindie.database.di

import android.content.Context
import com.thindie.database.LocalSourceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DaoModule::class, DataBaseModule::class, AdapterModule::class])
interface LocalSourceComponent : LocalSourceProvider {
    companion object {
        fun init(context: Context): LocalSourceComponent {
            return DaggerLocalSourceComponent
                .factory()
                .create(context)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): LocalSourceComponent
    }
}
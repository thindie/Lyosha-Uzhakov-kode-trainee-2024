package com.thindie.kodeTrainee.application

import android.app.Application
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.kodeTrainee.di.AppComponent

internal class KodeTraineeApplication: Application(), App {

    private lateinit var appComponent: AppComponent

    override fun getDependenciesProvider(): DependenciesProvider {
        return getAppComponent()
    }

     fun getAppComponent(): AppComponent {
        if (::appComponent.isInitialized.not()){
            appComponent = AppComponent.init(this)
        }
        return appComponent
    }
}
package com.thindie.application

import android.app.Application
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.di.AppComponent

class KodeTraineeApplication: Application(), App {

    private lateinit var appComponent: AppComponent

    override fun getDependenciesProvider(): DependenciesProvider {
      if (::appComponent.isInitialized.not()){
          appComponent = AppComponent.init(this)
      }
        return appComponent
    }
}
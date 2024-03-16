package com.thindie.kodeTrainee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.common.di.IODispatcher
import com.thindie.design_system.theme.KodeTraineeTheme
import com.thindie.kodeTrainee.application.KodeTraineeApplication
import com.thindie.kodeTrainee.di.AppComponent
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity(), App {
    @Inject
    internal lateinit var appCoordinator: AppCoordinator

    @Inject
    @IODispatcher
    lateinit var coroutineDispatcher: CoroutineDispatcher
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getAppComponent().inject(this)
        requestCoders()


        setContent {
            KodeTraineeTheme {
                KodeTraineeApp(
                    appCoordinator = appCoordinator,
                    coroutineDispatcher = coroutineDispatcher,
                    coroutineScope = lifecycleScope
                )
            }
        }
    }

    override fun getDependenciesProvider(): DependenciesProvider {
        return getAppComponent()
    }

    private fun getAppComponent(): AppComponent {
        val application = application as KodeTraineeApplication
        return application.getAppComponent()
    }

    fun requestCoders() {
        lifecycleScope.launch(coroutineDispatcher) { appCoordinator.loadingRequest() }
    }

}
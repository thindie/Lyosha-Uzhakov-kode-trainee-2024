package com.thindie.kodetrainee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.design_system.theme.KodeTraineeTheme

  class MainActivity : ComponentActivity(), App {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KodeTraineeTheme{

            }
        }
    }

    override fun getDependenciesProvider(): DependenciesProvider {
        val app = application as App
        return app.getDependenciesProvider()
    }
}
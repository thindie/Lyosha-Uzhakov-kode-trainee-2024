package com.thindie.kodeTrainee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalDensity
import com.thindie.common.App
import com.thindie.common.DependenciesProvider
import com.thindie.design_system.KodeTraineeDimenDefaults
import com.thindie.design_system.theme.KodeTraineeTheme
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults
import com.thindie.kodeTrainee.application.KodeTraineeApplication
import com.thindie.kodeTrainee.di.AppComponent

class MainActivity : ComponentActivity(), App {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            val density = LocalDensity.current
            KodeTraineeDimenDefaults.adjustPixelsToDp(density = density)
            KodeTraineeTypographyDefaults.adjustFontsSizeInPixelsToSp(density = density)
            KodeTraineeTheme {

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
}
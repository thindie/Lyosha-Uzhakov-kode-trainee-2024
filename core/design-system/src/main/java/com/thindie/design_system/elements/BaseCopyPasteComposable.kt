package com.thindie.design_system.elements

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thindie.design_system.theme.KodeTraineeTheme


@Composable
fun KDT(modifier: Modifier = Modifier){}

@Composable
@Preview
fun previewKDT(){
    KodeTraineeTheme {
        KDT()
    }
}
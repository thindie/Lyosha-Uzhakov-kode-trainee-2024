package com.thindie.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodySmall
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelSmall
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleLarge
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleSmall


val Typography = Typography(
    titleLarge = TextStyle(fontFamily = titleFamily, fontSize = titleLarge),
    titleMedium = TextStyle(fontFamily = titleFamily, fontSize = titleMedium),
    titleSmall = TextStyle(fontFamily = titleFamily, fontSize = titleSmall),
    bodyMedium = TextStyle(fontFamily = bodyFamily, fontSize = bodyMedium),
    bodySmall = TextStyle(fontFamily = bodyFamily, fontSize = bodySmall),
    labelMedium = TextStyle(fontFamily = labelFamily, fontSize = labelMedium),
    labelSmall = TextStyle(fontFamily = labelFamily, fontSize = labelSmall)

)
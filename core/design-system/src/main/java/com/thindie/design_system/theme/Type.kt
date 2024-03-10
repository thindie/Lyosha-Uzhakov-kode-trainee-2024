package com.thindie.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyMediumLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodySmall
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodySmallLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelMediumLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelSmall
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelSmallLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleLarge
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleLargeLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleMedium
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleMediumLineHeight
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleSmall
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleSmallLineHeight


val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = titleFamily,
        fontSize = titleLarge,
        lineHeight = titleLargeLineHeight
    ),
    titleMedium = TextStyle(
        fontFamily = titleFamily,
        fontSize = titleMedium,
        lineHeight = titleMediumLineHeight
    ),
    titleSmall = TextStyle(
        fontFamily = titleFamily,
        fontSize = titleSmall,
        lineHeight = titleSmallLineHeight
    ),
    bodyMedium = TextStyle(
        fontFamily = bodyFamily,
        fontSize = bodyMedium,
        lineHeight = bodyMediumLineHeight
    ),
    bodySmall = TextStyle(
        fontFamily = bodyFamily,
        fontSize = bodySmall,
        lineHeight = bodySmallLineHeight
    ),
    labelMedium = TextStyle(
        fontFamily = labelFamily,
        fontSize = labelMedium,
        lineHeight = labelMediumLineHeight
    ),
    labelSmall = TextStyle(
        fontFamily = labelFamily,
        fontSize = labelSmall,
        lineHeight = labelSmallLineHeight
    )

)
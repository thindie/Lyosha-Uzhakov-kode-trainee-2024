package com.thindie.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.bodyFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.displayFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.headLineFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.labelFamily
import com.thindie.design_system.theme.KodeTraineeTypographyDefaults.titleFamily


val Typography = Typography(
    displayLarge = TextStyle(fontFamily = displayFamily, fontSize = 57.sp, lineHeight = 64.sp),
    displayMedium = TextStyle(fontFamily = displayFamily, fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = TextStyle(fontFamily = displayFamily, fontSize = 36.sp, lineHeight = 44.sp),
    headlineLarge = TextStyle(fontFamily = headLineFamily, fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = TextStyle(fontFamily = headLineFamily, fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = TextStyle(fontFamily = headLineFamily, fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge = TextStyle(fontFamily = titleFamily, fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = TextStyle(
        fontFamily = titleFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(fontFamily = titleFamily, fontSize = 14.sp, lineHeight = 20.sp),
    bodyLarge = TextStyle(fontFamily = bodyFamily, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontFamily = bodyFamily, fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontFamily = bodyFamily, fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge = TextStyle(
        fontFamily = labelFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = labelFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = labelFamily,
        fontSize = 11.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 16.sp
    )

)
package com.stocknow.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    titleLarge  = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium,  color = TextPrimary),
    titleMedium = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium,  color = TextPrimary),
    titleSmall  = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Medium,  color = TextPrimary),
    bodyLarge   = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal,  color = TextPrimary),
    bodyMedium  = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Normal,  color = TextPrimary),
    bodySmall   = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal,  color = TextSecondary),
    labelSmall  = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium,  color = TextHint,
        letterSpacing = 0.07.sp),
)

package com.stocknow.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary          = Teal400,
    onPrimary        = Surface0,
    primaryContainer = IconBgGreen,
    secondary        = Blue400,
    background       = Surface1,
    surface          = Surface2,
    surfaceVariant   = Surface3,
    onBackground     = TextPrimary,
    onSurface        = TextPrimary,
    onSurfaceVariant = TextSecondary,
    outline          = Divider,
    error            = Red400,
)

@Composable
fun StockNowTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography  = Typography,
        content     = content,
    )
}

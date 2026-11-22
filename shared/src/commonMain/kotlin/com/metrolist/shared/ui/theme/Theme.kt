package com.metrolist.shared.ui.theme

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.metrolist.shared.ui.haptics.MetrolistHapticsProvider

// Цвета для стекла
val GlassWhite = Color(0x26FFFFFF) // 15% белого
val GlassBorder = Color(0x40FFFFFF) // 25% белого
val GlassBackground = Color(0xFF0F0A21) // Тёмная база

private val LightColors =
    lightColorScheme(
        primary = Color(0xFF7C3AED),
        onPrimary = Color.White,
        secondary = Color(0xFFB79CFF),
        onSecondary = Color.Black,
        background = Color(0xFFEEE9FF),
        onBackground = Color(0xFF1E1537),
        surface = Color(0xB3FFFFFF), // Полупрозрачный белый для карточек
        onSurface = Color(0xFF1E1537),
        error = Color(0xFFB00020),
        onError = Color.White,
    )

private val DarkColors =
    darkColorScheme(
        primary = Color(0xFFA78BFA),
        onPrimary = Color(0xFF1a0f3a),
        secondary = Color(0xFF6D28D9),
        onSecondary = Color.White,
        background = Color.Transparent, // Фон будет градиентным!
        onBackground = Color(0xFFF4F0FF),
        surface = GlassWhite, // Полупрозрачный белый для стекла
        onSurface = Color(0xFFF4F0FF),
        error = Color(0xFFCF6679),
        onError = Color.Black,
    )

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MetrolistTheme(
    useDarkTheme: Boolean = true, // Принудительно тёмная тема для стиля
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    val motionScheme = remember { MotionScheme.expressive() }
    
    // Оборачиваем всё в градиентный фон
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF6D28D9), // Ярко-фиолетовый
                        Color(0xFF0F0A21)  // Тёмный
                    ),
                    radius = 1200f
                )
            )
    ) {
        MaterialExpressiveTheme(
            colorScheme = animateColorScheme(colors, motionScheme),
            motionScheme = motionScheme,
            typography = Typography(),
            content = { MetrolistHapticsProvider(content) },
        )
    }
}

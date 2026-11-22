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
import com.metrolist.shared.ui.haptics.MetrolistHapticsProvider

// Твоя новая светлая тема (если включишь в настройках)
private val LightColors =
    lightColorScheme(
        primary = Color(0xFF7C3AED),      // Твой фиолетовый акцент
        onPrimary = Color.White,
        secondary = Color(0xFFB79CFF),
        onSecondary = Color.Black,
        background = Color(0xFFEEE9FF),   // Светло-фиолетовый фон
        onBackground = Color(0xFF1E1537),
        surface = Color.White,
        onSurface = Color(0xFF1E1537),
        error = Color(0xFFB00020),
        onError = Color.White,
    )

// Твоя новая тёмная тема (основная)
private val DarkColors =
    darkColorScheme(
        primary = Color(0xFFA78BFA),      // Светло-фиолетовый акцент (чтобы читалось на тёмном)
        onPrimary = Color(0xFF1a0f3a),    // Тёмный текст на фиолетовых кнопках
        secondary = Color(0xFF6D28D9),
        onSecondary = Color.White,
        background = Color(0xFF07040F),   // Самый тёмный фон (как в CSS --outer)
        onBackground = Color(0xFFF4F0FF), // Белый текст
        surface = Color(0xFF0F0A21),      // Фон карточек (как в CSS --bg-base)
        onSurface = Color(0xFFF4F0FF),
        error = Color(0xFFCF6679),
        onError = Color.Black,
    )

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MetrolistTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    val motionScheme = remember { MotionScheme.expressive() }
    MaterialExpressiveTheme(
        colorScheme = animateColorScheme(colors, motionScheme),
        motionScheme = motionScheme,
        typography = Typography(),
        content = { MetrolistHapticsProvider(content) },
    )
}

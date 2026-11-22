package com.metrolist.shared.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.glassmorphism(
    cornerRadius: Int = 28,
    backgroundColor: Color = GlassWhite,
    borderColor: Color = GlassBorder
): Modifier = this
    .clip(RoundedCornerShape(cornerRadius.dp))
    .background(backgroundColor)
    .border(1.dp, borderColor, RoundedCornerShape(cornerRadius.dp))

package com.example.pokedex.ui.components

import androidx.compose.ui.graphics.Color

fun mapStatColor(statName: String): Color {
    return when (statName.lowercase()) {
        "hp" -> Color(212,58,72)
        "attack" -> Color(255,166,37)
        "defense" -> Color(0,144,233)
        "special-attack" -> Color(58,142,57)
        "special-defense" -> Color(58,57,142)
        "speed" -> Color(144,175,197)
        else -> Color.Gray
    }
}
package com.example.pokedex.ui.components

fun mapStatName(statName: String): String {
    return when (statName.lowercase()) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SP. ATK"
        "special-defense" -> "SP. DEF"
        "speed" -> "SPEED"
        else -> ""
    }
}
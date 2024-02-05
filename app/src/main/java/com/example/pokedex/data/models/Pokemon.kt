package com.example.pokedex.data.models

data class Pokemon(
    val name: String,
    val sprites: Sprites,
    val types: Types,
    val weight: Int,
    val height: Int,
    val stats: Stats,
)

data class Sprites(
    val front_default: String,
)

data class Types(
    val type: Type,
)

data class Type(
    val name: String,
)

data class Stats(
    val base_stat: Int,
    val stat: Stat,
)

data class Stat(
    val name: String,
)


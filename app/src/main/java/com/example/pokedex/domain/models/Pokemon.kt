package com.example.pokedex.domain.models

import com.example.pokedex.data.models.PokemonDTO

data class Pokemon(
    val name: String,
    val spriteUrl: String,
    val type: String,
    val weight: Int,
    val height: Int,
    val baseStat: Int,
    val statName: String
) {
    constructor(dto: PokemonDTO) : this(
        dto.name,
        dto.sprites.front_default,
        dto.types.type.name,
        dto.weight,
        dto.height,
        dto.stats.base_stat,
        dto.stats.stat.name
    )
}

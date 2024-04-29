package com.example.pokedex.domain.models

import com.example.pokedex.data.models.PokemonDTO

data class Pokemon(
    val name: String,
    val spriteUrl: String,
    val type: String,
    val weight: Int,
    val height: Int,
    //val baseStat: Int,
    //val statName: String
    val stats: List<Stat>
) {
    constructor(dto: PokemonDTO) : this(
        dto.name,
        dto.sprites.front_default,
        dto.types.joinToString(", ") { it.type.name },
        dto.weight,
        dto.height,
        //dto.stats.firstOrNull()?.base_stat ?: 0,
        //dto.stats.firstOrNull()?.stat?.name ?: ""
        dto.stats.map { Stat(it.base_stat, it.stat.name) }
    )
}

data class Stat(
    val baseStat: Int,
    val name: String
)

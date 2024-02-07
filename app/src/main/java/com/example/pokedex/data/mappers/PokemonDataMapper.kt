package com.example.pokedex.data.mappers

import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon

object PokemonDataMapper {
    fun mapDtoToDomain(dto: PokemonDTO): Pokemon {
        return Pokemon(
            name = dto.name,
            spriteUrl = dto.sprites.front_default,
            type = dto.types.type.name,
            weight = dto.weight,
            height = dto.height,
            baseStat = dto.stats.base_stat,
            statName = dto.stats.stat.name
        )
    }
}
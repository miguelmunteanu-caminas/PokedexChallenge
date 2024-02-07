package com.example.pokedex.data.sources.local

import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import com.example.pokedex.data.models.Stats
import com.example.pokedex.data.models.Type
import com.example.pokedex.data.models.Types

class PokemonLocalDataSource(private val pokemonDao: PokemonDao) {
    suspend fun getPokemonList(): List<PokemonDTO> {
        return emptyList()
    }

    suspend fun getPokemonDetails(pokemonName: String): PokemonDTO {
        return PokemonDTO(name = "", sprites = Sprites(""), types = Types(Type("")), weight = 0, height = 0, stats = Stats(0, Stat("")))
    }
}
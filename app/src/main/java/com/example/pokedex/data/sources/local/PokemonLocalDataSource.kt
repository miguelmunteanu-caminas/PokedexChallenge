package com.example.pokedex.data.sources.local

import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import com.example.pokedex.data.models.StatDetail
//import com.example.pokedex.data.models.Stats
import com.example.pokedex.data.models.Type
import com.example.pokedex.data.models.Types

class PokemonLocalDataSource(private val pokemonDao: PokemonDao) {

    suspend fun getPokemonDetails(pokemonName: String): PokemonDTO {
        return PokemonDTO(name = "", sprites = Sprites(""), listOf(Types(Type(""))), weight = 0, height = 0, stats = listOf(Stat(0, stat = StatDetail(""))))
    }
}
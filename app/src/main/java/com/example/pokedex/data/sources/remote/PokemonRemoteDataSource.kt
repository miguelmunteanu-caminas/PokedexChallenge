package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.models.PokemonDTO

class PokemonRemoteDataSource(private val pokemonApiService: PokemonApiService) {
    suspend fun getPokemonList(): List<PokemonDTO> {
        return pokemonApiService.getPokemonList()
    }

    suspend fun getPokemonDetails(pokemonName: String): PokemonDTO {
        return pokemonApiService.getPokemonDetails(pokemonName)
    }
}
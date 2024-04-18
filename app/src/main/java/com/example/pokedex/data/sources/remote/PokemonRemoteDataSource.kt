package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.models.PokemonDTO

class PokemonRemoteDataSource(private val pokemonApiService: PokemonApiService) {

    suspend fun getPokemonDetails(): PokemonDTO {
        return pokemonApiService.getPokemonDetails()
    }
}
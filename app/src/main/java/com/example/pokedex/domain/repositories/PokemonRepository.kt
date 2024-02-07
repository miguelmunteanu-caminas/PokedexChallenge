package com.example.pokedex.domain.repositories

interface PokemonRepository<Pokemon> {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemonDetails(pokemonName: String): Pokemon
}
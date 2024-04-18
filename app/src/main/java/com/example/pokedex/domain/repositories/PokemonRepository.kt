package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.Pokemon

interface PokemonRepository {
    suspend fun getPokemonDetails(): Pokemon
}
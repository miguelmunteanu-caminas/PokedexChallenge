package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.models.PokemonDTO
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemonList(): List<PokemonDTO>

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonDetails(@Path("pokemonName") pokemonName: String): PokemonDTO
}
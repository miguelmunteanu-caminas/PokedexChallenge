package com.example.pokedex.domain.usecases

import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository

class GetPokemonDetailUseCase(private val repository: PokemonRepository<Pokemon>) {
    suspend operator fun invoke(pokemonName: String): Pokemon {
        return repository.getPokemonDetails(pokemonName)
    }
}
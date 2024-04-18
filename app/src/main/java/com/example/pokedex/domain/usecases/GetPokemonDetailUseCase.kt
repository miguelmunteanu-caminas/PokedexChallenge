package com.example.pokedex.domain.usecases

import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(): Pokemon {
        return repository.getPokemonDetails()
    }

}

/*
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository

class GetPokemonDetailUseCase(private val repository: PokemonRepository) {
    suspend operator fun invoke(pokemonName: String): Pokemon {
        return repository.getPokemonDetails(pokemonName)
    }
}*/
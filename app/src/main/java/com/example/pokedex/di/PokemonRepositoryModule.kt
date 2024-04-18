package com.example.pokedex.di

import com.example.pokedex.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonRepositoryModule {

    @Binds
    abstract fun bindRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}
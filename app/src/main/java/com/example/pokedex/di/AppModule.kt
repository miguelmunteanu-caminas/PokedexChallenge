package com.example.pokedex.di

import android.app.Application
import com.example.pokedex.R
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.repositories.PokemonRepositoryImpl
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.domain.repositories.PokemonRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun providePokemonApiService(gson: Gson): PokemonApiService {
        val pokemonDTO: PokemonDTO = gson.fromJson(R.raw.ditto, PokemonDTO::class.java)

        //return
    }
}
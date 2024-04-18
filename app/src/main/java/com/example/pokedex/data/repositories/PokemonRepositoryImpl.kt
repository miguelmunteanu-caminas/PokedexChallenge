package com.example.pokedex.data.repositories

import android.app.Application
import android.content.Context
import androidx.annotation.RawRes
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonApiClient
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    val application: Application
): PokemonRepository {

    override suspend fun getPokemonDetails(): Pokemon {
        val json = InputStreamReader(application.applicationContext.assets.open("ditto.json"))
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()

        val pokendto = gson.fromJson(json, PokemonDTO::class.java)
        return PokemonDataMapper.mapDtoToDomain(pokendto)
    }
}

/*
import android.content.Context
import androidx.annotation.RawRes
import com.example.pokedex.data.mappers.PokemonDataMapper
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.PokemonApiClient
import com.example.pokedex.data.sources.remote.PokemonApiService
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApiService: PokemonApiService,
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource,
    private val pokemonDataMapper: PokemonDataMapper,
    @RawRes private val rawResId: Int,
    private val context: Context
): PokemonRepository<PokemonDTO> {

    override suspend fun getPokemonList(): List<PokemonDTO> {
        val localPokemonList = pokemonLocalDataSource.getPokemonList()

        return if (localPokemonList.isNotEmpty()) {
            localPokemonList
        } else {
            val remotePokemonList = pokemonRemoteDataSource.getPokemonList()
            remotePokemonList
        }
    }

    override suspend fun getPokemonDetails(pokemonName: String): PokemonDTO {
        /*val localPokemonDetails = pokemonLocalDataSource.getPokemonDetails(pokemonName)

        return if (localPokemonDetails.name.isNotEmpty()) {
            localPokemonDetails
        } else {
            val remotePokemonDetails = pokemonRemoteDataSource.getPokemonDetails(pokemonName)
            remotePokemonDetails
        }*/
        val inputStream = context.resources.openRawResource(rawResId)
        val jsonString = inputStream.bufferedReader().use { it.readText() }

        val pokemonList: List<PokemonDTO> = Gson().fromJson(jsonString, object : TypeToken<List<PokemonDTO>>() {}.type)

        val selectedPokemon: PokemonDTO? = pokemonList.find { it.name == pokemonName }

        return selectedPokemon ?: pokemonApiService.getPokemonDetails(pokemonName)
    }
}
*/
package com.example.pokedex.data.sources.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApiClient {
    private const val BASE_URL = "urlInventada.com" // Esta parte la he encontrado en internet y la he puesto por poner...

    val apiService: PokemonApiService by lazy {
        createRetrofit().create(PokemonApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
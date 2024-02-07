package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import com.example.pokedex.data.models.Stats
import com.example.pokedex.data.models.Type
import com.example.pokedex.data.models.Types
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private var _pokemon = Pokemon(PokemonDTO("", Sprites(""), Types(Type("")), 0, 0, Stats(0, Stat(""))))

    val pokemon: Pokemon get() = _pokemon

    fun getPokemonDetails(pokemonName: String): Pokemon {
        return runBlocking {
            getPokemonDetailUseCase(pokemonName)
        }
    }
}
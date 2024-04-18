package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.data.models.Sprites
import com.example.pokedex.data.models.Stat
import com.example.pokedex.data.models.StatDetail
//import com.example.pokedex.data.models.Stats
import com.example.pokedex.data.models.Type
import com.example.pokedex.data.models.Types
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecases.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(getPokemonDetails())
    val uiState: StateFlow<Pokemon> = _uiState.asStateFlow()

    private var _pokemon = Pokemon(PokemonDTO("", Sprites(""), listOf(Types(Type(""))), 0, 0, listOf(Stat(0, StatDetail("")))))

    val pokemon: Pokemon get() = _pokemon

    fun getPokemonDetails(): Pokemon {
        return runBlocking {
            getPokemonDetailUseCase()
        }
    }
}
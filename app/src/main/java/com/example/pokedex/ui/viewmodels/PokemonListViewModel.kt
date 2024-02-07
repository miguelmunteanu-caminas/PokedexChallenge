package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    application: Application,
    private val pokemonRepository: PokemonRepository<PokemonDTO>
) : AndroidViewModel(Application()) {

    //private var _pokemon = MutableLiveData<PokemonDTO>()
    //val pokemon: LiveData<PokemonDTO> = _pokemon
    //Iba a hacerlo para un pokemon Ditto, pero al final he pensado hacerlo una lista por si en un futuro quisiese meter más pokemons

    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> get() = _pokemonList

    init {
        loadPokemonList()
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            val loadedPokemonList = withContext(Dispatchers.IO) {
                pokemonRepository.getPokemonList()
            }
            _pokemonList.postValue(loadedPokemonList.map {
                Pokemon(it)
            })
        }
    }
}
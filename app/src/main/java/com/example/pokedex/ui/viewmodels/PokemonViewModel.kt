package com.example.pokedex.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.models.PokemonDTO

class PokemonViewModel(application: Application) : AndroidViewModel(Application()) {

    private var _pokemon = MutableLiveData<PokemonDTO>()

    val pokemon: LiveData<PokemonDTO> = _pokemon
}

class PokemonViewModel2 : ViewModel() {

}
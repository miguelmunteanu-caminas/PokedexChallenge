package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PokemonDetailView() {
    val viewModel: PokemonDetailViewModel = viewModel()
    val pokemon = viewModel.getPokemonDetails()

    Column {
        Text("Name: ${pokemon.name}")
        Text("Type: ${pokemon.type}")
        Text("Weight: ${pokemon.weight}")
        Text("Height: ${pokemon.height}")
    }
}
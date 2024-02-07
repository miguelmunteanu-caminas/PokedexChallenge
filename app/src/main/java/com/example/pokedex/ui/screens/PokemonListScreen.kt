package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.ui.viewmodels.PokemonListViewModel


/*@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel,
    onItemClick: (PokemonDTO) -> Unit
) {
    val pokemonList = viewModel.pokemonList.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokemon List")
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        content = {
            /*PokemonList(
                pokemonList = pokemonList,
                onItemClick = onItemClick
            )*/
        }
    )
}

@Composable
private fun PokemonList(
    pokemonList: List<PokemonDTO>,
    onItemClick: (PokemonDTO) -> Unit
) {
    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonListItem(
                pokemon = pokemon,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun PokemonListItem(
    pokemon: PokemonDTO,
    onItemClick: (PokemonDTO) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(pokemon)
            }
            .padding(16.dp)
    ) {
        Text(text = pokemon.name)
        Spacer(modifier = Modifier.height(8.dp))
        // etc etc, pondría más cosas
    }
}*/
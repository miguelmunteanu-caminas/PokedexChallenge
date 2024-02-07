package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screens.PokemonDetailScreen
import com.example.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokedexApp()
                    layoutPrincipal()
                }
            }
        }
    }
}

@Composable
fun layoutPrincipal() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pokemonListScreen"
    ) {
        composable("pokemonDetailScreen/{pokemonName}") { backStackEntry ->
            val pokemonName =
                backStackEntry.arguments?.getString("pokemonName") ?: "DefaultPokemonName"
            PokemonDetailScreen(
                navController = navController,
                pokemonName = pokemonName,
                viewModel = hiltViewModel()
            )
        }
    }
}
package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.ui.components.showPokemonImage
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(
    navController: NavHostController,
    viewModel: PokemonDetailViewModel
) {
    var isExpanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokedex", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                        }
                },
                actions = {

                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(197, 123, 230))
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .background(Color(40, 40, 40))
                .fillMaxHeight()
        ) {
            PokemonDetailView()
        }
    }
}
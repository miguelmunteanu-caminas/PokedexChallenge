package com.example.pokedex.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.components.PokemonDetailView
import com.example.pokedex.ui.theme.PokedexTheme
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.data.models.PokemonDTO
import com.example.pokedex.ui.components.backgroundColor
import com.example.pokedex.ui.components.boldText
import com.example.pokedex.ui.components.dimensionName
import com.example.pokedex.ui.components.dittoColor
import com.example.pokedex.ui.components.mapStatName
import com.example.pokedex.ui.components.pokemonBaseStatsFontSize
import com.example.pokedex.ui.components.pokemonDimensionsFontSize
import com.example.pokedex.ui.components.pokemonNameFontSize
import com.example.pokedex.ui.components.pokemonTypeFontSize
import com.example.pokedex.ui.components.showPokemonImage
import com.example.pokedex.ui.components.statBox
import com.example.pokedex.ui.components.statNameText
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailScreen(
    navController: NavHostController,
    viewModel: PokemonDetailViewModel
) {
    val pokemon = viewModel.getPokemonDetails()

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
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = dittoColor)
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .background(backgroundColor)
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp))
                    .background(dittoColor)
                    .padding(PaddingValues(all = 20.dp))
            ) {
                showPokemonImage(pokemon)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                boldText("${pokemon.name}", pokemonNameFontSize)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 20.dp)
            ) {
                Box(modifier = Modifier
                    .width(100.dp)
                    .height(30.dp)
                    .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                    .background(Color(204, 102, 0))
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        boldText(text = "${pokemon.type}", fontsize = pokemonTypeFontSize)
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Row {
                        boldText(text = "${pokemon.weight} KG", fontsize = pokemonDimensionsFontSize)
                    }
                    dimensionName(text = "Weight")
                }
                Column {
                    Row {
                        boldText(text = "${pokemon.weight} M", fontsize = pokemonDimensionsFontSize)
                    }
                    dimensionName(text = "Height")

                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 10.dp)
            ) {
                boldText(text = "Base Stats", fontsize = pokemonBaseStatsFontSize)
            }
            for (stat in pokemon.stats) {
                Row(
                    modifier = Modifier
                        .padding(all = 7.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .width(100.dp)
                    ) {
                        statNameText(text = stat.name)
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        val percentage = (stat.baseStat.toFloat() / 300) * 100

                        statBox(stat = stat, percentage = percentage)
                    }
                }
            }
        }
    }
}
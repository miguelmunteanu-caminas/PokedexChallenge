package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.Stat


const val pokemonNameFontSize = 36
const val pokemonTypeFontSize = 20
const val pokemonDimensionsFontSize = 22
const val pokemonBaseStatsFontSize = 22

val dittoColor = Color(197, 123, 230)
val backgroundColor = Color(40, 40, 40)

@Composable
fun PokemonDetailView() {
    val viewModel: PokemonDetailViewModel = hiltViewModel<PokemonDetailViewModel>()
    val pokemon = viewModel.getPokemonDetails()

}
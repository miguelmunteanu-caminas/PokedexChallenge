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

fun mapStatName(statName: String): String {
    return when (statName.lowercase()) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SP. ATK"
        "special-defense" -> "SP. DEF"
        "speed" -> "SPEED"
        else -> ""
    }
}

fun mapStatColor(statName: String): Color {
    return when (statName.lowercase()) {
        "hp" -> Color(212,58,72)
        "attack" -> Color(255,166,37)
        "defense" -> Color(0,144,233)
        "special-attack" -> Color(58,142,57)
        "special-defense" -> Color(58,57,142)
        "speed" -> Color(144,175,197)
        else -> Color.Gray
    }
}

@Composable
fun showPokemonImage(pokemon: Pokemon) {
    Image(
        painter = rememberImagePainter(
            data = pokemon.spriteUrl
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(175.dp),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun boldText(text: String, fontsize: Int) {
    Text("${text}", fontSize = fontsize.sp, fontWeight = FontWeight.Bold, color = Color.White)
}

@Composable
fun dimensionName(text: String) {
    Text("${text}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(123,120,124),  modifier = Modifier.padding(all = 7.dp))
}

@Composable
fun statNameText(text: String) {
    Text(text = mapStatName(text).uppercase(), color = Color.LightGray)
}

@Composable
fun statBox(stat: Stat, percentage: Float) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
            .width(250.dp)
            .height(20.dp)
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(percentage / 100f)
                .height(20.dp)
                .background(mapStatColor(stat.name))
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(text = "${stat.baseStat} / 300")
        }
    }
}
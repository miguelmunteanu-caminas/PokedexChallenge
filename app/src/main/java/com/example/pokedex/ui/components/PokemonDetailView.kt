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

@Composable
fun PokemonDetailView() {
    val viewModel: PokemonDetailViewModel = hiltViewModel<PokemonDetailViewModel>()
    val pokemon = viewModel.getPokemonDetails()

    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(0.dp, 0.dp, 40.dp, 40.dp))
            .background(Color(197, 123, 230))
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
        //Text("${pokemon.name}", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.White)
        boldText("${pokemon.name}", 36)
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
                //Text("${pokemon.type}", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                boldText(text = "${pokemon.type}", fontsize = 20)
            }
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Row {
                Text("${pokemon.weight} KG", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Text(text = "Weight", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(123,120,124), modifier = Modifier.padding(all = 7.dp))
        }
        Column {
            Row {
                Text("${pokemon.height} M", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Text(text = "Height", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(123,120,124),  modifier = Modifier.padding(all = 7.dp))
        }
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 10.dp)
    ) {
        Text(text = "Base Stats", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.White)
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
                Text(text = mapStatName(stat.name).uppercase(), color = Color.LightGray)
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
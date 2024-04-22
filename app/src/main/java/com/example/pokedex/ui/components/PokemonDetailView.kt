package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.ui.viewmodels.PokemonDetailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter

@Composable
fun PokemonDetailView() {
    val viewModel: PokemonDetailViewModel = hiltViewModel<PokemonDetailViewModel>()
    val pokemon = viewModel.getPokemonDetails()

    Column(
        modifier = Modifier
            .background(Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Magenta)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = pokemon.spriteUrl
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("${pokemon.name}", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("${pokemon.type}", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Row {
                    Text("${pokemon.weight} KG", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
                Text(text = "Weight", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
            Column {
                Row {
                    Text("${pokemon.height} M", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
                Text(text = "Height", fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Base Stats", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
        for (stat in pokemon.statName) {
            Row{
                Text(text = "${stat}")
            }
        }
    }
}
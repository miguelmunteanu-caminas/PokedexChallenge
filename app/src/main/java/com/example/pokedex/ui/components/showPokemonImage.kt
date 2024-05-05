package com.example.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.pokedex.domain.models.Pokemon

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
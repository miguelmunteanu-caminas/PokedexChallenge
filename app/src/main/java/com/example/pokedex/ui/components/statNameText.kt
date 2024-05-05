package com.example.pokedex.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun statNameText(text: String) {
    Text(text = mapStatName(text).uppercase(), color = Color.LightGray)
}
package com.example.pokedex.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun boldText(text: String, fontsize: Int) {
    Text("${text}", fontSize = fontsize.sp, fontWeight = FontWeight.Bold, color = Color.White)
}
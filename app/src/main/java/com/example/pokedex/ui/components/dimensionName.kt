package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun dimensionName(text: String) {
    Text("${text}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(123,120,124),  modifier = Modifier.padding(all = 7.dp))
}
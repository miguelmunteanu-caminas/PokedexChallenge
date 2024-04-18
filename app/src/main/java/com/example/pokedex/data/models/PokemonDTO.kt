package com.example.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("types")
    val types: List<Types>,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("stats")
    val stats: List<Stat>
)

data class Sprites(
    @SerializedName("front_default")
    val front_default: String,
)

data class Types(
    @SerializedName("type")
    val type: Type,
)

data class Type(
    @SerializedName("name")
    val name: String,
)

data class Stat(
    @SerializedName("base_stat")
    val base_stat: Int,
    @SerializedName("stat")
    val stat: StatDetail,
)

data class StatDetail(
    @SerializedName("name")
    val name: String,
)


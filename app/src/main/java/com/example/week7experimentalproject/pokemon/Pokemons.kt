package com.example.week7experimentalproject.pokemon

import com.example.week7experimentalproject.Pokjson.Result

data class Pokemons (
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)
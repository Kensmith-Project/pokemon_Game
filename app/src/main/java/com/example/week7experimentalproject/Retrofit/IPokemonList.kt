package com.example.week7experimentalproject.Retrofit

import com.example.week7experimentalproject.Pokemons
import retrofit2.Response
import retrofit2.http.GET

interface IPokemonList {
    @GET("/api/v2/pokemon?limit=100&offset=200.")
    suspend fun listPokemon(): Response<Pokemons>

//    @GET("/{num}")
//    fun getSinglePokemon(num: Int): Call<pokegitto>
}
package com.example.week7experimentalproject.Retrofit

import com.example.week7experimentalproject.Model.Pokemon
import com.example.week7experimentalproject.pokedata.pokegitto
import com.example.week7experimentalproject.pokemon.Pokemons
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
//The Interface that interacts with the server by getting, or posting resources to the server

interface IPokemonList {
    @GET("/api/v2/pokemon?limit=1126&offset=1")
    suspend fun listPokemon(): Response<Pokemons>

    @GET("/api/v2/pokemon/{name}")
   suspend fun getPokemon(@Path("name")name:String):Response<pokegitto>



}
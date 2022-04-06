package com.example.week7experimentalproject.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {
//Serves as a courutine that enable activities to carryout multiple activities at the background thread
    val api: IPokemonList by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPokemonList::class.java)
    }
}
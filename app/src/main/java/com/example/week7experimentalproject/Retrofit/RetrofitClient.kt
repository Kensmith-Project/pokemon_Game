package com.example.week7experimentalproject.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {
//    private var ourInstance: Retrofit? = null
//    val instance:Retrofit
//        get() {
//            if (ourInstance == null)
//                ourInstance = Retrofit.Builder()
//                    .baseUrl("https://pokeapi.co/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build()
//            return ourInstance!!
//        }
    val api: IPokemonList by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPokemonList::class.java)
    }
}
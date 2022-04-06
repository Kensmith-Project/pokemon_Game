 package com.example.week7experimentalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week7experimentalproject.Adapter.PokenListAdapter
import com.example.week7experimentalproject.Model.pokedex
import com.example.week7experimentalproject.Retrofit.IPokemonList
import com.example.week7experimentalproject.Retrofit.RetrofitClient

import io.reactivex.disposables.CompositeDisposable
import okio.IOException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

// Here we launch all the codes on the project
 class MainActivity : AppCompatActivity() {
  // Was set to be used later in this project
     internal var compositeDisposable = CompositeDisposable()

     internal lateinit var poken_recyclerview: RecyclerView

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         //get the view of the reycycler and get it ready fro binding
         poken_recyclerview = findViewById(R.id.pokeemon_recyclerView2)
  //Fetch the resources from the server
         fetchData()
     }
     override fun onResume() {
         super.onResume()

     }

    //Making a request from the server
     private fun fetchData() {

         lifecycleScope.launchWhenCreated {
             var response = try {
                 RetrofitClient.api.listPokemon()
             } catch (e: IOException) {
                 println("IOException")
                 return@launchWhenCreated
             } catch (e: HttpException) {
                 println("HttpException")
                 return@launchWhenCreated
             }

             if (response.isSuccessful && response.body() != null) {
                 val results = response.body()!!.results
                 var i = 1
                 for (result in results) {
                     result.url =
                         "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${i}.png"
                     i++
                 }
                 println("Successful")
                 val adapter = PokenListAdapter(results)
                 poken_recyclerview.adapter = adapter
                 poken_recyclerview.layoutManager = GridLayoutManager(this@MainActivity, 2)

             } else {
                 println("Failed!")
             }
         }
     }
 }
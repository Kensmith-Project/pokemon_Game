 package com.example.week7experimentalproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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


 class MainActivity : AppCompatActivity() {

    internal  var compositeDisposable= CompositeDisposable()
//    internal var iPokemonList: IPokemonList
    internal lateinit var poken_recyclerview: RecyclerView

    init {
//        val retrofit= RetrofitClient.instance
//        iPokemonList=retrofit.create(IPokemonList::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poken_recyclerview = findViewById(R.id.pokeemon_recyclerView2)
////        poken_recyclerview.setHasFixedSize(true)
//        poken_recyclerview.layoutManager= LinearLayoutManager(this)
//        val itemDecoration= ItemOffsetDecoration(this,R.dimen.spacing)
//        poken_recyclerview.addItemDecoration(itemDecoration)
        fetchData()
    }

     override fun onResume() {
         super.onResume()

     }

//     @SuppressLint("LogNotTimber")
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
                     result.url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${i}.png"
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

//         iPokemonList.listPokemon().enqueue(object : Callback<List<Pokemons>> {

//             override fun onResponse(call: Call<pokedex?>, response: Response<pokedex?>) {
//                 if (response.isSuccessful) {
//                     Log.d("AAAAAAAAAAAA", "fetchData: ${response.body()}")
//                     val adapter =
//                         response.body()?.pokemon?.let { PokenListAdapter(this@MainActivity, it ) }
//                     println(adapter)
//                     poken_recyclerview.adapter= adapter
//                 }
//             }
//
//             override fun onFailure(call: Call<pokedex?>, t: Throwable) {
//
//             }

//             override fun onResponse(
//                 call: Call<List<pokegitto>>,
//                 response: Response<List<Pokemons>>
//             ) {
//                 if (response.isSuccessful) {
//                     Log.d("AAAAAAAAAAAA", "fetchData: ${response.body()}")
////                     val adapter =
////                         response.body()!!
////                     println(adapter)
////                     poken_recyclerview.adapter= adapter
//
//                 }
//             }

//             override fun onFailure(call: Call<List<pokegitto>>, t: Throwable) {
//
//             }

//             override fun onResponse(
//                 call: Call<List<Pokemons>>,
//                 response: Response<List<Pokemons>>
//             ) {
//                 println(response.body()!!.toList())
//             }
//
//             override fun onFailure(call: Call<List<Pokemons>>, t: Throwable) {
//                 println(t.message)
//             }
//         })

//         var pokemon_recyclerview =
//             compositeDisposable.add(iPokemonList.listPokemon
//                 .subscribeOn(Schedulers.io())
//                 .observeOn(AndroidSchedulers.mainThread())
//                 .subscribe { pokedex ->
////                     Common.pokemonList = pokedex.pokemon!!
//                     Log.d("AAAAAAAAAAAA", "fetchData: ${pokedex.pokemon!!}")
//                     val adapter = PokenListAdapter(this, pokedex.pokemon!!)
//                     poken_recyclerview.adapter= adapter
//
//                 }
//
//             );
     }
}
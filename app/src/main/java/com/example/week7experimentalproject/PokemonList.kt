package com.example.week7experimentalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week7experimentalproject.Adapter.PokenListAdapter
import com.example.week7experimentalproject.Retrofit.IPokemonList
import com.example.week7experimentalproject.Retrofit.RetrofitClient
import com.example.week7experimentalproject.common.Common
//import com.example.week7experimentalproject.common.ItemOffsetDecoration
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers


import io.reactivex.schedulers.Schedulers

class PokemonList : Fragment() {
//    internal  var compositeDisposable= CompositeDisposable()
//    internal var iPokemonList:IPokemonList
//    internal  lateinit var poken_recyclerview:RecyclerView
//
//    init {
//
//        val retrofit= RetrofitClient.instance
//        iPokemonList=retrofit.create(IPokemonList::class.java)
//
//    }
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        var itemView:View = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
//
//       poken_recyclerview = itemView.findViewById(R.id.pokeemon_recyclerView) as RecyclerView
//        poken_recyclerview.setHasFixedSize(true)
//        poken_recyclerview.layoutManager= GridLayoutManager(activity,2)
//        val itemDecoration= ItemOffsetDecoration(requireActivity(),R.dimen.spacing)
//        poken_recyclerview.addItemDecoration(itemDecoration)
//
//        fetchData()
//
//        return  itemView
//
//    }
//
//    private fun fetchData() {
//        var pokemon_recyclerview =
//        compositeDisposable.add(iPokemonList.listPokemon
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { pokedex ->
//                Common.pokemonList= pokedex.pokemon!!
//              val adapter = PokenListAdapter(requireActivity(),Common.pokemonList)
//                poken_recyclerview.adapter= adapter
//
//            }
//
//        );
//    }

}
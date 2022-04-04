package com.example.week7experimentalproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week7experimentalproject.R
import com.example.week7experimentalproject.Result

class PokenListAdapter(var pokemonlist:List<Result>):RecyclerView.Adapter<PokenListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView:View= LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(this)
                .load(pokemonlist[position].url)
                .into(holder.img_pokemon)
        }
        holder.txt_pokemon.text= pokemonlist[position].name
    }

    override fun getItemCount(): Int {
        return pokemonlist.size
    }

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        internal var img_pokemon : ImageView = itemView.findViewById(R.id.pokemon_image) as ImageView
        internal var txt_pokemon :TextView = itemView.findViewById(R.id.pokemon_name) as TextView
    }
}
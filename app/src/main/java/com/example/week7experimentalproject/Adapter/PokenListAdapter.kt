package com.example.week7experimentalproject.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week7experimentalproject.Interface.IItemClickListener
import com.example.week7experimentalproject.R
import com.example.week7experimentalproject.Pokjson.Result
import com.example.week7experimentalproject.pokemonDetail.PokemonDetailDisplay
  //The Adapter that holds the recycler list of Pokemon
class PokenListAdapter(var pokemonlist:List<Result>):RecyclerView.Adapter<PokenListAdapter.MyViewHolder>() {

//Creates the view Holder that holds the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView:View= LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item,parent,false)
        return MyViewHolder(itemView)
    }
  //Here we bound all the items in Our Pokemon List to the Recycler view that display the lists of the pokemon
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(this)
                .load(pokemonlist[position].url)
                .into(holder.img_pokemon)
        }
        holder.txt_pokemon.text= pokemonlist[position].name


        holder.img_pokemon.setOnClickListener { it ->
            Toast.makeText(holder.img_pokemon.context, pokemonlist[position].name, Toast.LENGTH_SHORT).show()

val intent= Intent(holder.itemView.context,PokemonDetailDisplay::class.java)
            intent.putExtra("EXTRA_NAME",pokemonlist[position].name)
            startActivity(holder.itemView.context,intent,null)

        }
    }
//Gets the size of the recycler list
    override fun getItemCount(): Int {
        return pokemonlist.size
    }
//Locates each item for binding, It enable the recycler list to access each property
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        internal var img_pokemon : ImageView = itemView.findViewById(R.id.pokemon_image) as ImageView
        internal var txt_pokemon :TextView = itemView.findViewById(R.id.pokemon_name) as TextView
       internal  var itemClickListener:IItemClickListener?= null
        fun  setItemClickListener(iItemClickListener: IItemClickListener){
            this.itemClickListener= iItemClickListener
        }

    }
}
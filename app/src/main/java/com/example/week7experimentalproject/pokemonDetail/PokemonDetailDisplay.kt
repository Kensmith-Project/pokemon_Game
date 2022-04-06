package com.example.week7experimentalproject.pokemonDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.week7experimentalproject.Adapter.PokenListAdapter
import com.example.week7experimentalproject.R
import com.example.week7experimentalproject.Retrofit.RetrofitClient
import okio.IOException
import retrofit2.HttpException
// An activity that displays the details of each  pokemon
class PokemonDetailDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail_display2)
            // get the instance of the attribute passed through the intent in the main class
        val name = intent.getStringExtra("EXTRA_NAME")
        val tvName = findViewById<TextView>(R.id.iv_name_onepoke)
        tvName.text = name
        //Call and launch the server again to be able to access the url resource using retrofit
        lifecycleScope.launchWhenCreated {
           //Handle the Internet exception in case if it is offline
            var response = try {
                RetrofitClient.api.getPokemon(name.toString())
            } catch (e: IOException) {
                println("IOException")
                return@launchWhenCreated
            } catch (e: HttpException) {
                println("HttpException")
                return@launchWhenCreated
            }
            //Having gotten the response, find the view of each pokemon component and set it to our server api resource atrributes
            if (response.isSuccessful && response.body() != null) {
                val results = response.body()!!
                findViewById<TextView>(R.id.iv_meters).text = results.height.toString()
                findViewById<TextView>(R.id.iv_weight_num).text= results.weight.toString()
                findViewById<TextView>(R.id.iv_moves_num).text=results.order.toString()
               findViewById<TextView>(R.id.iv_id_num).text= results.id.toString()
                findViewById<TextView>(R.id.iv_base_experience).text= results.base_experience.toString()

                Glide.with(this@PokemonDetailDisplay)
                    .load(results.sprites.other.home.front_default)
                    .into(findViewById<ImageView>(R.id.iv_one_poke_image))
                //Using loops to set the stats progress attribute to our progressbar in the pokemon detail activity

                for (i in results.stats.indices) {
                    if (results.stats[i].stat.name == "attack") {
                        findViewById<ProgressBar>(R.id.progressBar_iv_attack).progress =
                            results.stats[i].base_stat
                    } else if (results.stats[i].stat.name == "defense") {
                        findViewById<ProgressBar>(R.id.progressBar_iv_defense).progress =
                            results.stats[i].base_stat
                    } else if (results.stats[i].stat.name == "special-attack") {
                        findViewById<ProgressBar>(R.id.progressBar_iv_special_attack).progress =
                            results.stats[i].base_stat
                    } else if (results.stats[i].stat.name == "special-defense") {
                        findViewById<ProgressBar>(R.id.iv_progress_special_defense).progress =
                            results.stats[i].base_stat
                    } else if (results.stats[i].stat.name == "speed") {
                        findViewById<ProgressBar>(R.id.progressBar_iv_speed).progress =
                            results.stats[i].base_stat
                    }else if(results.stats[i].stat.name == "poison") {

                        findViewById<ProgressBar>(R.id.iv_health_progressBar).progress= results.stats[i].base_stat

                    } else if(results.stats[i].stat.name == "hp"){
                        findViewById<ProgressBar>(R.id.progressBar_iv_hp).progress= results.stats[i].base_stat

                    }else{
                        println("Failed!")
                    }
                }
            }
        }
    }
}



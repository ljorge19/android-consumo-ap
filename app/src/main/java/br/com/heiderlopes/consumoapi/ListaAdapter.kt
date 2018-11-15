package br.com.heiderlopes.consumoapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.heiderlopes.consumoapi.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_search.view.*

class ListaAdapter(
        val pokemons: List<Pokemon>,
        val context: Context,
        val listener: (Pokemon) -> Unit):
        RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder?.let {
            it.bindView(pokemon, listener)
        }
    }


    class ViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {

        fun bindView(pokemon: Pokemon,
                     listener: (Pokemon) -> Unit) = with(itemView) {

            tvPokemon.text = pokemon.name
            Picasso.get()
                    .load(pokemon?.sprites?.frontDefault)
                    .placeholder(R.drawable.searching)
                    .error(R.drawable.notfound)
                    .into(ivPokemon)
            setOnClickListener { listener(pokemon) }

        }

    }


}
package com.pdev.apppeliculas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pdev.apppeliculas.domain.Movie
import com.pdev.apppeliculas.domain.Pelicula
import com.pdev.apppeliculas.domain.Result

class RecyclerViewMovieAdapter constructor(private val getActivity: PeliculasActivity, private val movieList: List<Movie>) :
    RecyclerView.Adapter<RecyclerViewMovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMovieTitle.text = movieList[position].title
        holder.ivMovieImg.setImageResource(movieList[position].image)
        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity, movieList[position].title, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMovieTitle : TextView = itemView.findViewById(R.id.tvMovieTitle)
        val ivMovieImg : ImageView = itemView.findViewById(R.id.ivMovieImg)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}
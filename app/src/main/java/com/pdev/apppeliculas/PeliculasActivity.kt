package com.pdev.apppeliculas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pdev.apppeliculas.domain.Movie
import com.pdev.apppeliculas.domain.Pelicula
import com.pdev.apppeliculas.domain.Result
import com.pdev.apppeliculas.util.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class PeliculasActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var recyclerViewMovieAdapter : RecyclerViewMovieAdapter? = null
    private var movieList = mutableListOf<Movie>()
    private var context : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        movieList = ArrayList()
        context = this

        val retrofitTraer = RetrofitClient.consumirApi.getObtenerPeliculas()
        retrofitTraer.enqueue(object : Callback<Pelicula>{
            override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                Log.i("Pelicula", "########Consume API")
                println(response.body().toString())
                val items = response.body()?.results
                Log.i("Pelicula", "########items $items")
                if(items != null){
                    for (i in 0 until items.count()){
                        val title = items[i].title ?: "N/A"
                        Log.i("Pelicula", "########Title $title" )
                        val urlImage = items[i].backdrop_path ?: ""
                        var movie = Movie(title, R.drawable.movie, urlImage)
                        movieList.add(movie)
                    }
                }

                recyclerView = findViewById<View>(R.id.rvMovieLists) as RecyclerView
                recyclerViewMovieAdapter = RecyclerViewMovieAdapter(this@PeliculasActivity, movieList)
                var layoutManager : RecyclerView.LayoutManager = GridLayoutManager(context, 2)
                recyclerView!!.layoutManager = layoutManager
                recyclerView!!.adapter = recyclerViewMovieAdapter
            }

            override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                println("Failed to get movies")
            }

        })

        //prepareMovieListData()

    }

    /*private fun prepareMovieListData(){
        var movie = Movie("Avatar", R.drawable.jumanji)
        movieList.add(movie)
        movie = Movie("Batman", R.drawable.jumanji)
        movieList.add(movie)
        movie = Movie("Avenger", R.drawable.jumanji)
        movieList.add(movie)
        movie = Movie("Jumangi", R.drawable.jumanji)
        movieList.add(movie)

        val retrofitTraer = RetrofitClient.consumirApi.getObtenerPeliculas()
        retrofitTraer.enqueue(object : Callback<Pelicula>{
            override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                Log.i("Pelicula", "########Consume API")
                println(response.body().toString())
                val items = response.body()?.results
                Log.i("Pelicula", "########items $items")
                if(items != null){
                    for (i in 0 until items.count()){
                        val title = items[i].title ?: "N/A"
                        Log.i("Pelicula", "########Title $title" )
                        var movie = Movie(title, R.drawable.jumanji)
                        movieList.add(movie)
                    }
                }
            }

            override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                println("Failed to get movies")
            }

        })
    }*/
}
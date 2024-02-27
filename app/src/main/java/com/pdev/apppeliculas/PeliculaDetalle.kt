package com.pdev.apppeliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pdev.apppeliculas.core.Constantes

class PeliculaDetalle : AppCompatActivity() {

    lateinit var ivMovieImgDet : ImageView
    lateinit var tvMovieTitleDet : TextView
    lateinit var tvVoteAverageDet : TextView
    lateinit var tvReleaseDateDet : TextView
    lateinit var tvOverviewDet : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula_detalle)

        ivMovieImgDet = findViewById(R.id.ivMovieImgDet)
        tvMovieTitleDet = findViewById(R.id.tvMovieTitleDet)
        tvVoteAverageDet = findViewById(R.id.tvVoteAverageDet)
        tvReleaseDateDet = findViewById(R.id.tvReleaseDateDet)
        tvOverviewDet = findViewById(R.id.tvOverviewDet)

        val intent = intent
        val title = intent.getStringExtra("title")
        println("title: $title")
        val urlImage = intent.getStringExtra("urlImage")
        val voteAverage = intent.getStringExtra("voteAverage")
        val releaseDate = intent.getStringExtra("releaseDate")
        val overview = intent.getStringExtra("overview")

        Glide
            .with(this)
            .load("${Constantes.BASE_URL_IMAGE}${urlImage}")
            //.apply(RequestOptions().override(Constantes.IMAGE_ANCHO, Constantes.IMAGE_ALTO))
            .into(ivMovieImgDet)

        tvMovieTitleDet.text = title
        tvVoteAverageDet.text = voteAverage
        tvReleaseDateDet.text = releaseDate
        tvOverviewDet.text = overview
    }
}
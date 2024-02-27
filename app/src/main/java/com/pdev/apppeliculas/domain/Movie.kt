package com.pdev.apppeliculas.domain

data class Movie(
    var title: String, var image: Int, var urlImage: String,
    var voteAverage: String, var releaseDate: String, var overview: String
)
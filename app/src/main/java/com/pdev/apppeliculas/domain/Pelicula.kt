package com.pdev.apppeliculas.domain

data class Pelicula(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
package com.pdev.apppeliculas.util

import com.pdev.apppeliculas.domain.Pelicula
import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {

    @GET("upcoming?page=1&api_key=869b6dbff6a02a59292434b6221f3233")
    fun getObtenerPeliculas(): Call<Pelicula>

}
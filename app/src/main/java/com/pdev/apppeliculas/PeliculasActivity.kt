package com.pdev.apppeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.pdev.apppeliculas.domain.Pelicula
import com.pdev.apppeliculas.util.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {

    lateinit var btnConsultar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        btnConsultar = findViewById(R.id.btnConsultar)

        btnConsultar.setOnClickListener {
            val retrofitTraer = RetrofitClient.consumirApi.getObtenerPeliculas()
            retrofitTraer.enqueue(object : Callback<Pelicula>{
                override fun onResponse(call: Call<Pelicula>, response: Response<Pelicula>) {
                    println(response.body().toString())
                }

                override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                    println("Failed to get movies")
                }

            })
        }

    }
}
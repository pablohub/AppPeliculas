package com.pdev.apppeliculas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var userNameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameInput = findViewById(R.id.txtUserName)
        passwordInput = findViewById(R.id.txtUserPassword)
        loginBtn = findViewById(R.id.btnLogin)

        loginBtn.setOnClickListener {
            val userName = userNameInput.text.toString()
            val password = passwordInput.text.toString();

            if(userName.equals("admin") && password.equals("123")){
                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
            }else{
                val toast = Toast.makeText(applicationContext, "Credenciales Incorrectas!", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

    }
}
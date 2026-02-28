package com.example.mb210230desafio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnPromedio = findViewById<Button>(R.id.btnPromedio)
        val btnSalario = findViewById<Button>(R.id.btnSalario)
        val btnCalculadora = findViewById<Button>(R.id.btnCalculadora)

        btnPromedio.setOnClickListener {
            val intent = Intent(this, PromedioActivity::class.java)
            startActivity(intent)
        }

        btnSalario.setOnClickListener {
            val intent = Intent(this, DescuentoSalario::class.java)
            startActivity(intent)
        }

        btnCalculadora.setOnClickListener {
            val intent = Intent(this, calculadora::class.java)
            startActivity(intent)
        }
    }
}
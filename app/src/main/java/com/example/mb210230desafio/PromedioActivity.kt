package com.example.mb210230desafio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)
        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val etNota3 = findViewById<EditText>(R.id.etNota3)
        val etNota4 = findViewById<EditText>(R.id.etNota4)
        val etNota5 = findViewById<EditText>(R.id.etNota5)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {

            val nota1 = etNota1.text.toString().toDoubleOrNull()
            val nota2 = etNota2.text.toString().toDoubleOrNull()
            val nota3 = etNota3.text.toString().toDoubleOrNull()
            val nota4 = etNota4.text.toString().toDoubleOrNull()
            val nota5 = etNota5.text.toString().toDoubleOrNull()

            if (nota1 != null && nota2 != null && nota3 != null && nota4 != null && nota5 != null) {

                val promedio = (nota1 + nota2 + nota3 + nota4 + nota5) / 5
                tvResultado.text = "Resultado: $promedio"

            } else {
                tvResultado.text = "Ingrese valores válidos"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.mb210230desafio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class PromedioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promedio)
        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editNota1 = findViewById<EditText>(R.id.editNota1)
        val etNota2 = findViewById<EditText>(R.id.editNota2)
        val etNota3 = findViewById<EditText>(R.id.editNota3)
        val etNota4 = findViewById<EditText>(R.id.editNota4)
        val etNota5 = findViewById<EditText>(R.id.editNota5)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.textviewResultado)
        val tvEstado = findViewById<TextView>(R.id.textviewEstado)


        btnCalcular.setOnClickListener {

            val nombre = editNombre.text.toString()

            val nota1 = editNota1.text.toString().toDoubleOrNull()
            val nota2 = etNota2.text.toString().toDoubleOrNull()
            val nota3 = etNota3.text.toString().toDoubleOrNull()
            val nota4 = etNota4.text.toString().toDoubleOrNull()
            val nota5 = etNota5.text.toString().toDoubleOrNull()

            if (nombre.isNotEmpty() &&
                nota1 != null && nota2 != null &&
                nota3 != null && nota4 != null && nota5 != null) {

                //validacion del rango, en lo del punto 5 o literal 5.
                if (nota1 !in 0.0..10.0 ||
                    nota2 !in 0.0..10.0 ||
                    nota3 !in 0.0..10.0 ||
                    nota4 !in 0.0..10.0 ||
                    nota5 !in 0.0..10.0) {

                    tvResultado.text = "ERROR una/varias de las ntas no esta entre 0 y 10"
                    tvEstado.text = ""
                    return@setOnClickListener
                }

                val promedio =
                    (nota1 * 0.15) +
                            (nota2 * 0.15) +
                            (nota3 * 0.20) +
                            (nota4 * 0.25) +
                            (nota5 * 0.25)

                val df = DecimalFormat("#.00")
                val promedioFormateado = df.format(promedio)

                tvResultado.text = "Resultado: $promedioFormateado"

                if (promedio >= 6.0) {
                    tvEstado.text = "Aprobado"
                } else {
                    tvEstado.text = "Reprobado"
                }
            }
        }
    }
}
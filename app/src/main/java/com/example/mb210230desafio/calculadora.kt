package com.example.mb210230desafio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.sqrt

class calculadora : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNum1 = findViewById<EditText>(R.id.editNum1)
        val editNum2 = findViewById<EditText>(R.id.editNum2)//Inge deje 2 numeros porque me parecio lo más simple, 2 numeros se pueden sumar, restar etc.
        val textviewResultado = findViewById<TextView>(R.id.textviewResultado)

        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)
        val btnExponente = findViewById<Button>(R.id.btnExponente)
        val btnRaiz = findViewById<Button>(R.id.btnRaiz)

        btnSuma.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingrese número 1"
                return@setOnClickListener
            }

            if (editNum2.text.toString().isEmpty()) {
                editNum2.error = "Ingrese número 2"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()
            val n2 = editNum2.text.toString().toDouble()

            textviewResultado.text = "Resultado: " + (n1 + n2)
        }

        btnResta.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingrese numero 1"
                return@setOnClickListener
            }

            if (editNum2.text.toString().isEmpty()) {
                editNum2.error = "Ingrese numero 2"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()
            val n2 = editNum2.text.toString().toDouble()

            textviewResultado.text = "Resultado: " + (n1 - n2)
        }

        btnMultiplicar.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingrese numero 1"
                return@setOnClickListener
            }

            if (editNum2.text.toString().isEmpty()) {
                editNum2.error = "Ingrese numero 2"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()
            val n2 = editNum2.text.toString().toDouble()

            textviewResultado.text = "Resultado: " + (n1 * n2)
        }

        btnDividir.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingrese numero 1"
                return@setOnClickListener
            }

            if (editNum2.text.toString().isEmpty()) {
                editNum2.error = "Ingrese numero 2"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()
            val n2 = editNum2.text.toString().toDouble()

            if (n2 == 0.0) {
                Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            textviewResultado.text = "Resultado: " + (n1 / n2)
        }

        btnExponente.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingrese número 1"
                return@setOnClickListener
            }

            if (editNum2.text.toString().isEmpty()) {
                editNum2.error = "Ingrese númro 2"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()
            val n2 = editNum2.text.toString().toDouble()

            textviewResultado.text = "Resultado: " + n1.pow(n2)
        }

        btnRaiz.setOnClickListener {

            if (editNum1.text.toString().isEmpty()) {
                editNum1.error = "Ingreese número 1"
                return@setOnClickListener
            }

            val n1 = editNum1.text.toString().toDouble()

            if (n1 < 0) {
                Toast.makeText(this, "No se puede raiz de numero negaativo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            textviewResultado.text = "Resultado: " + sqrt(n1)
        }
    }
}
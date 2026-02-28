package com.example.mb210230desafio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DescuentoSalario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descuento_salario)

        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editSalario = findViewById<EditText>(R.id.editSalario)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.textviewResultado)

        btnCalcular.setOnClickListener {

            val nombre = editNombre.text.toString()
            val salarioTexto = editSalario.text.toString()

            if (nombre.isEmpty()) {
                editNombre.error = "Ingrese nombre"
                return@setOnClickListener
            }

            if (salarioTexto.isEmpty()) {
                editSalario.error = "Ingrese salario"
                return@setOnClickListener
            }

            val salario = salarioTexto.toDouble()

            if (salario <= 0) {
                editSalario.error = "El salario debe ser positivo"
                return@setOnClickListener
            }

            val afp = salario * 0.0725
            val isss = salario * 0.03
            val renta = calcularRenta(salario)
            val neto = salario - afp - isss - renta

            resultado.text =
                "Empleado: " + nombre +
                        "\n\nSalario Base: " + salario +
                        "\nAFP (7.25%): " + afp +
                        "\nISSS (3%): " + isss +
                        "\nRenta: " + renta +
                        "\n\nSalario Neto: " + neto
        }
    }
    private fun calcularRenta(salario: Double): Double {
        return when {
            salario <= 472.00 -> 0.0
            salario <= 895.24 -> (salario - 472.00) * 0.10 + 17.67
            salario <= 2038.10 -> (salario - 895.24) * 0.20 + 60.00
            else -> (salario - 2038.10) * 0.30 + 288.57
        }
    }
}
package com.joao_ar11.calculadoradeimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        inicializarComponentesInterface()

        val bundle = intent.extras

        if (bundle == null) {
            finish()
            return
        }

        val peso = bundle.getDouble("peso")
        val altura = bundle.getDouble("altura")

        textPeso.text = "Peso Informado: $peso kg"
        textAltura.text = "Altura Informada: $altura m"

        val imc = peso / (altura * altura)

        val resultado = when(imc) {
            in 0.0..18.4 -> "Baixo"
            in 18.5..24.9 -> "Normal"
            in 25.0..29.9 -> "Sobrepeso"
            else -> "Obeso"
        }

        textResultado.text = resultado

    }

    private fun inicializarComponentesInterface() {
        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)
    }
}
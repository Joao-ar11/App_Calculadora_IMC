package com.joao_ar11.calculadoradeimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputPeso: TextInputLayout
    private lateinit var editPeso: TextInputEditText

    private lateinit var textInputAltura: TextInputLayout
    private lateinit var editAltura: TextInputEditText

    private lateinit var buttonCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()

        buttonCalcular.setOnClickListener {
            val resultadoValidacao = validarCampos()

            if (resultadoValidacao) {
                val peso = editPeso.text.toString()
                val altura = editAltura.text.toString()
                val intent: Intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", peso.toDouble())

                startActivity(intent)
            }
        }
    }

    private fun validarCampos(): Boolean {
        textInputPeso.error = ""
        textInputAltura.error = ""

        val peso = editPeso.text.toString()
        val altura = editAltura.text.toString()

        if (peso.isEmpty()) {
            textInputPeso.error = "Digite o peso"
            return false
        } else if (altura.isEmpty()) {
            textInputAltura.error = "Digite a altura"
            return false
        }

        return true
    }

    private fun inicializarComponentesInterface() {
        textInputPeso = findViewById(R.id.text_input_peso)
        editPeso = findViewById(R.id.edit_peso)

        textInputAltura = findViewById(R.id.text_input_altura)
        editAltura = findViewById(R.id.edit_altura)

        buttonCalcular = findViewById(R.id.button_calcular)
    }
}
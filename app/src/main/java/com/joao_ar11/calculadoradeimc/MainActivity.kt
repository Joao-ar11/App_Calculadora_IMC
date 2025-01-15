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
    }

    private fun inicializarComponentesInterface() {
        textInputPeso = findViewById(R.id.text_input_peso)
        editPeso = findViewById(R.id.edit_peso)

        textInputAltura = findViewById(R.id.text_input_altura)
        editAltura = findViewById(R.id.edit_altura)

        buttonCalcular = findViewById(R.id.button_calcular)
    }
}
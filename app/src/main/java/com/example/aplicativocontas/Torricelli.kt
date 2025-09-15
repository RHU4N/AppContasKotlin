package com.example.aplicativocontas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Torricelli : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_torricelli)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val velocidadeInicial = findViewById<EditText>(R.id.edtVelI)
        val aceleracao = findViewById<EditText>(R.id.edtAce)
        val deslocamento = findViewById<EditText>(R.id.edtDesl)
        val calc = findViewById<Button>(R.id.btnTorri)
        val resultado = findViewById<TextView>(R.id.txtResultTorri)

        calc.setOnClickListener {
            val velInicial = velocidadeInicial.text.toString().toDoubleOrNull()
            val ace = aceleracao.text.toString().toDoubleOrNull()
            val desl = deslocamento.text.toString().toDoubleOrNull()

            // Verifica se algum campo é nulo ou inválido
            if (velInicial == null || ace == null || desl == null) {
                resultado.text = "Valores inválidos"
                return@setOnClickListener
            }

            // Calcula v^2
            val vQuadrado = velInicial * velInicial + 2 * ace * desl

            // Verifica se v^2 é negativo (não existe solução real)
            if (vQuadrado < 0) {
                resultado.text = "Cálculo inválido (raiz negativa)"
                return@setOnClickListener
            }

            // Calcula a velocidade final
            val velFinal = kotlin.math.sqrt(vQuadrado)

            // Exibe o resultado
            resultado.text = "Velocidade final: %.2f m/s".format(velFinal)
        }


    }
}
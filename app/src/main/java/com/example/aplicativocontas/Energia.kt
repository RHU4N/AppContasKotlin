package com.example.aplicativocontas

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Energia : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_energia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val massa = findViewById<EditText>(R.id.edtMassEner)
        val velocidade = findViewById<EditText>(R.id.edtVelEnerg)
        val calcular = findViewById<Button>(R.id.btnCalcEnerg)
        val resultado = findViewById<TextView>(R.id.txtResultEnerg)

        calcular.setOnClickListener {
            val mas = massa.text.toString().toDouble()
            val vel = velocidade.text.toString().toDouble()
            if (mas.toString().isEmpty() || vel.toString().isEmpty()) {
                resultado.text = "Coloque algum valor"
                Toast.makeText(this, resultado.text, Toast.LENGTH_LONG).show()

            }
            else if (mas <= 0 || vel <= 0) {
                resultado.text = "Valores inválidos"
                Toast.makeText(this, resultado.text, Toast.LENGTH_LONG).show()
            }
            else{
                val calc = (mas * (vel*vel))/2
                resultado.text = calc.toString()
            }
        }

    }
}
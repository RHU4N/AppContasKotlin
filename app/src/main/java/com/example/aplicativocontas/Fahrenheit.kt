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

class Fahrenheit : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fahrenheit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fahrenheit = findViewById<EditText>(R.id.edtTempFah)
        val calc = findViewById<Button>(R.id.btnCalcFtoC)
        val result = findViewById<TextView>(R.id.txtResultFtoC)

        calc.setOnClickListener {
            val temp = fahrenheit.text.toString().toDouble()
            if (temp == null){
                result.text = "Escreva um valor válido"
                Toast.makeText(this, result.text, Toast.LENGTH_LONG).show()
            }else{
                val celsius = (temp - 32) * 5 / 9
                result.text = "A temperatura em Celsius é: $celsius C°"
            }
        }
    }
}
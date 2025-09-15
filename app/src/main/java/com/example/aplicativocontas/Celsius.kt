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

class Celsius : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_celsius)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val celsius = findViewById<EditText>(R.id.edtTempCel)
        val calc = findViewById<Button>(R.id.btnCalcCtoF)
        val result = findViewById<TextView>(R.id.txtResultCtoF)

        calc.setOnClickListener {
            val c = celsius.text.toString().toDouble()
            if (c == null){
                result.text = "Digite um valor"
                Toast.makeText(this, result.text, Toast.LENGTH_SHORT).show()
            }else{
                val f = (c * 1.8) + 32
                result.text = "O valor em Fahrenheit é: $f F°"
            }
        }
    }
}
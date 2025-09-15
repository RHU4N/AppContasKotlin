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

class Forca : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forca)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val massa = findViewById<EditText>(R.id.edtMass)
        val acel = findViewById<EditText>(R.id.edtAce)
        val btnCalcFor = findViewById<Button>(R.id.btnCalcFor)
        val res = findViewById<TextView>(R.id.txtResultFor)

        btnCalcFor.setOnClickListener {
            if (massa.text.isEmpty() || acel.text.isEmpty()) {
                res.text = "Preencha todos os campos"
                Toast.makeText(this, res.text, Toast.LENGTH_LONG).show()
            } else if(massa.text.toString().toDouble() < 0 || acel.text.toString().toDouble() < 0) {
                res.text = "Valores inválidos"
                Toast.makeText(this, res.text, Toast.LENGTH_LONG).show()
            }else{
                val forca = massa.text.toString().toDouble() * acel.text.toString().toDouble()
                res.text = "A Força é %.2f N".format(forca)
            }
        }

    }
}
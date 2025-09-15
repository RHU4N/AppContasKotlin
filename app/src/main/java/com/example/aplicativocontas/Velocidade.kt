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

class Velocidade : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_velocidade)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dist = findViewById<EditText>(R.id.edtDist)
        val temp = findViewById<EditText>(R.id.edtTemp)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val res = findViewById<TextView>(R.id.txtResult)

        btnCalc.setOnClickListener {
            if (dist.text.toString().toDoubleOrNull() == null || temp.text.toString().toDoubleOrNull() == null) {
                res.text = "Por favor, insira valores válidos para distância e tempo."
                Toast.makeText(this, res.text, Toast.LENGTH_LONG).show()
            } else if (temp.text.toString().toDouble() == 0.0) {
                res.text = "O tempo não pode ser zero."
                Toast.makeText(this, res.text, Toast.LENGTH_LONG).show()
            } else {
                val v = dist.text.toString().toDouble() / temp.text.toString().toDouble()
                res.text = "A velocidade é %.2f m/s".format(v)
            }
        }
    }
}
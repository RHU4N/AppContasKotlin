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

class AreaPara : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_area_para)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val comprimento = findViewById<EditText>(R.id.edtComp)
        val largura = findViewById<EditText>(R.id.edtlag)
        val altura = findViewById<EditText>(R.id.edtAltura)
        val btnAPara = findViewById<Button>(R.id.btnAPara)
        val txtResultAVPara = findViewById<TextView>(R.id.txtResultAVPara)

        btnAPara.setOnClickListener {
            val comp = comprimento.text.toString().toDoubleOrNull()
            val larg = largura.text.toString().toDoubleOrNull()
            val alt = altura.text.toString().toDoubleOrNull()

            if (comp == null || larg == null || alt == null || comp <= 0 || larg <= 0 || alt <= 0) {
                txtResultAVPara.text = "Valores inválidos"
                return@setOnClickListener
            }

            val area = 2 * (comp * larg + comp * alt + larg * alt)
            val volume = comp * larg * alt

            txtResultAVPara.text = "Área: $area\nVolume: $volume"

        }
    }
}
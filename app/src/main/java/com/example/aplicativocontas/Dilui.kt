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

class Dilui : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dilui)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val conI = findViewById<EditText>(R.id.edtConI)
        val volI = findViewById<EditText>(R.id.edtVolI)
        val conII = findViewById<EditText>(R.id.edtConII)
        val volII = findViewById<EditText>(R.id.edtVolII)
        val btnDilui = findViewById<Button>(R.id.btnDilui)
        val txtResultDilui = findViewById<TextView>(R.id.txtResultDilui)

        btnDilui.setOnClickListener {
            val c1 = conI.text.toString().toDouble()
            val v1 = volI.text.toString().toDouble()
            val c2 = conII.text.toString().toDouble()
            val v2 = volII.text.toString().toDouble()

            if(c1 < 0 || v1 < 0 || c2 < 0 || v2 < 0){
                txtResultDilui.text = "Valores inválidos"
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_LONG).show()
            }else if(v1 == 0.0 || v2 == 0.0){
                txtResultDilui.text = "Valores inválidos"
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_LONG).show()
            }else if(c2>c1){
                txtResultDilui.text = "Valores inválidos"
                Toast.makeText(this, "Valores inválidos", Toast.LENGTH_LONG).show()
            }else if(c1 >= 0 && v1 > 0 && c2>= 0 && v2 > 0 && c2 <= c1){
                val res = (c1*v1)/(c2*v2)
                txtResultDilui.text = "O resultado é: $res Mol/L"

                }
            }

        }
    }

package com.example.aplicativocontas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnVel = findViewById<Button>(R.id.btnVel)
        var btnFor = findViewById<Button>(R.id.btnFor)
        var btnEnerg = findViewById<Button>(R.id.btnEnerg)
        var btnFtoC = findViewById<Button>(R.id.btnFtoC)
        var btnCtoF = findViewById<Button>(R.id.btnCtoF)
        var btnAreaPara = findViewById<Button>(R.id.btnAreaPara)
        var btnTorri = findViewById<Button>(R.id.btnTorri)
        var btnDilui = findViewById<Button>(R.id.btnDilui)

        btnVel.setOnClickListener {
            val intent = Intent(this, Velocidade::class.java)
            startActivity(intent)
        }
        btnFor.setOnClickListener {
            val intent = Intent(this, Forca::class.java)
            startActivity(intent)
        }
        btnEnerg.setOnClickListener {
            val intent = Intent(this, Energia::class.java)
            startActivity(intent)
        }
        btnFtoC.setOnClickListener {
            val intent = Intent(this, Fahrenheit::class.java)
            startActivity(intent)
        }
        btnCtoF.setOnClickListener {
            val intent = Intent(this, Celsius::class.java)
            startActivity(intent)
        }
        btnAreaPara.setOnClickListener {
            val intent = Intent(this, AreaPara::class.java)
            startActivity(intent)
        }
        btnTorri.setOnClickListener {
            val intent = Intent(this, Torricelli::class.java)
            startActivity(intent)
        }
        btnDilui.setOnClickListener {
            val intent = Intent(this, Dilui::class.java)
            startActivity(intent)
        }



    }
}
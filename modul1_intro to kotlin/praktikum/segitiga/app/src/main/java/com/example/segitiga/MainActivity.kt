package com.example.segitiga

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editAlas: EditText
    private lateinit var editTinggi: EditText
    private lateinit var buttonHitung: Button
    private lateinit var textHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editAlas = findViewById(R.id.edit_alas)
        editTinggi = findViewById(R.id.edit_tinggi)
        buttonHitung = findViewById(R.id.button_hitung)
        textHasil = findViewById(R.id.text_hasil)

        buttonHitung.setOnClickListener {
            val alas = editAlas.text.toString().toDouble()
            val tinggi = editTinggi.text.toString().toDouble()
            val luas = 0.5 * alas * tinggi
            textHasil.text = "Luas segitiga = $luas"
        }
    }
}
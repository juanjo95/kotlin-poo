package com.androidavanzadotutorial.poo

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PaletteTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_text)

        var tvEjemplo:TextView = findViewById(R.id.tvEjemplo)
        tvEjemplo.text = "Texto cambiado desde codigo"
        tvEjemplo.setTextColor(Color.RED)
        tvEjemplo.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
    }
}
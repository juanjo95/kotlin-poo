package com.androidavanzadotutorial.poo

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class PaletteTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_text)

        var tvEjemplo:TextView = findViewById(R.id.tvEjemplo)
        tvEjemplo.apply {
            this.text = "Texto cambiado desde codigo"
            this.setTextColor(Color.RED)
            this.setTypeface(Typeface.MONOSPACE,Typeface.BOLD)
        }

        tvEjemplo.setOnClickListener {
            Toast.makeText(this,"Texto",Toast.LENGTH_SHORT).show()
            tvEjemplo.setTextColor(Color.GREEN)
        }

    }
}